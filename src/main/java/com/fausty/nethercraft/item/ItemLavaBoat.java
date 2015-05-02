package com.fausty.nethercraft.item;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemLavaBoat extends ItemBase {

    public ItemLavaBoat(String internalName) {
        super(internalName);
    }

    @SuppressWarnings("unchecked")
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        final EntityLavaBoat entityBoat = new EntityLavaBoat(world);
        final float f = 1.0f;
        final float f2 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        final float f3 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        final double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
        double d = player.prevPosY + (player.posY - player.prevPosY) * f + player.getEyeHeight();
        if (world.isRemote) {
            d -= player.getDefaultEyeHeight();
        }
        final double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
        Vec3 vec3 = Vec3.createVectorHelper(d0, d, d2);
        final float f4 = MathHelper.cos(-f3 * 0.017453292f - 3.1415927f);
        final float f5 = MathHelper.sin(-f3 * 0.017453292f - 3.1415927f);
        final float f6 = -MathHelper.cos(-f2 * 0.017453292f);
        final float f7 = MathHelper.sin(-f2 * 0.017453292f);
        final float f8 = f5 * f6;
        final float f9 = f4 * f6;
        final double d3 = 5.0;
        final Vec3 vec2 = vec3.addVector(f8 * d3, f7 * d3, f9 * d3);
        final MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3, vec2, true);
        if (movingobjectposition == null) {
            return stack;
        }
        vec3 = player.getLook(f);
        boolean flag = false;
        final float f10 = 1.0f;
        final List<Entity> list = (List<Entity>) world.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.addCoord(vec3.xCoord * d3, vec3.yCoord * d3, vec3.zCoord * d3).expand((double) f10, (double) f10, (double) f10));
        for (final Entity entity : list) {
            if (entity.canBeCollidedWith()) {
                final float f11 = entity.getCollisionBorderSize();
                final AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double) f11, (double) f11, (double) f11);
                if (!axisalignedbb.isVecInside(vec3)) {
                    continue;
                }
                flag = true;
            }
        }
        if (flag) {
            return stack;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (world.getBlock(i, j, k) == Blocks.snow_layer) {
                --j;
            }
            entityBoat.setPosition((double) (i + 0.5f), (double) (j + 1.0f), (double) (k + 0.5f));
            entityBoat.rotationYaw = ((MathHelper.floor_double(player.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) - 1) * 90;
            if (!world.getCollidingBoundingBoxes(entityBoat, entityBoat.boundingBox.expand(-0.1, -0.1, -0.1)).isEmpty()) {
                return stack;
            }
            if (!world.isRemote) {
                world.spawnEntityInWorld(entityBoat);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
        }
        return stack;
    }

}
