package com.fausty.nethercraft.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.List;

public abstract class EntityBoatBase extends EntityBoat {

    private static Field field_isBoatEmpty;
    private static Field field_speedMultiplier;
    private static Field field_boatPosRotationIncrements;
    private static Field field_boatX;
    private static Field field_boatY;
    private static Field field_boatZ;
    private static Field field_boatYaw;
    private static Field field_boatPitch;

    public static void init() {
        EntityBoatBase.field_isBoatEmpty = getField("isBoatEmpty", "field_70279_a");
        EntityBoatBase.field_speedMultiplier = getField("speedMultiplier", "field_70276_b");
        EntityBoatBase.field_boatPosRotationIncrements = getField("boatPosRotationIncrements", "field_70277_c");
        EntityBoatBase.field_boatX = getField("boatX", "field_70274_d");
        EntityBoatBase.field_boatY = getField("boatY", "field_70275_e");
        EntityBoatBase.field_boatZ = getField("boatZ", "field_70272_f");
        EntityBoatBase.field_boatYaw = getField("boatYaw", "field_70273_g");
        EntityBoatBase.field_boatPitch = getField("boatPitch", "field_70281_h");
    }

    private static Field getField(String deobfName, String srgName) {
        Field ret;
        try {
            ret = EntityBoat.class.getDeclaredField(deobfName);
        }
        catch (Exception e2) {
            try {
                ret = EntityBoat.class.getDeclaredField(srgName);
            }
            catch (Exception e1) {
                throw new RuntimeException("Can't find field " + deobfName + "/" + srgName, e1);
            }
        }
        ret.setAccessible(true);
        return ret;
    }

    public EntityBoatBase(World world) {
        super(world);
    }

    @SuppressWarnings("unchecked")
    public void onUpdate() {
        super.onEntityUpdate();
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final byte b0 = 5;
        double d0 = 0.0;
        for (int i = 0; i < b0; ++i) {
            final double d = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * i / b0 - 0.125;
            final double d2 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (i + 1) / b0 - 0.125;
            final AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(this.boundingBox.minX, d, this.boundingBox.minZ, this.boundingBox.maxX, d2, this.boundingBox.maxZ);
            if (this.isOnWater(axisalignedbb)) {
                d0 += 1.0 / b0;
            }
        }
        final double d3 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (d3 > 0.26249999999999996) {
            final double d4 = Math.cos(this.rotationYaw * 3.141592653589793 / 180.0);
            final double d5 = Math.sin(this.rotationYaw * 3.141592653589793 / 180.0);
            for (int j = 0; j < 1.0 + d3 * 60.0; ++j) {
                final double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
                final double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    final double d8 = this.posX - d4 * d6 * 0.8 + d5 * d7;
                    final double d9 = this.posZ - d5 * d6 * 0.8 - d4 * d7;
                    this.worldObj.spawnParticle("smoke", d8, this.posY - 0.125, d9, this.motionX, this.motionY, this.motionZ);
                }
                else {
                    final double d8 = this.posX + d4 + d5 * d6 * 0.7;
                    final double d9 = this.posZ + d5 - d4 * d6 * 0.7;
                    this.worldObj.spawnParticle("smoke", d8, this.posY - 0.125, d9, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
        try {
            if (this.worldObj.isRemote && EntityBoatBase.field_isBoatEmpty.getBoolean(this)) {
                int boatPosRotationIncrements = EntityBoatBase.field_boatPosRotationIncrements.getInt(this);
                if (boatPosRotationIncrements > 0) {
                    final double d4 = this.posX + (EntityBoatBase.field_boatX.getDouble(this) - this.posX) / boatPosRotationIncrements;
                    final double d5 = this.posY + (EntityBoatBase.field_boatY.getDouble(this) - this.posY) / boatPosRotationIncrements;
                    final double d10 = this.posZ + (EntityBoatBase.field_boatZ.getDouble(this) - this.posZ) / boatPosRotationIncrements;
                    final double d11 = MathHelper.wrapAngleTo180_double(EntityBoatBase.field_boatYaw.getDouble(this) - this.rotationYaw);
                    this.rotationYaw += (float) (d11 / boatPosRotationIncrements);
                    this.rotationPitch += (float) ((EntityBoatBase.field_boatPitch.getDouble(this) - this.rotationPitch) / boatPosRotationIncrements);
                    --boatPosRotationIncrements;
                    EntityBoatBase.field_boatPosRotationIncrements.setInt(this, boatPosRotationIncrements);
                    this.setPosition(d4, d5, d10);
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                }
                else {
                    final double d4 = this.posX + this.motionX;
                    final double d5 = this.posY + this.motionY;
                    final double d10 = this.posZ + this.motionZ;
                    this.setPosition(d4, d5, d10);
                    if (this.onGround) {
                        this.motionX *= 0.5;
                        this.motionY *= 0.5;
                        this.motionZ *= 0.5;
                    }
                    this.motionX *= 0.9900000095367432;
                    this.motionY *= 0.949999988079071;
                    this.motionZ *= 0.9900000095367432;
                }
            }
            else {
                if (d0 < 1.0) {
                    final double d4 = d0 * 2.0 - 1.0;
                    this.motionY += 0.03999999910593033 * d4;
                }
                else {
                    if (this.motionY < 0.0) {
                        this.motionY /= 2.0;
                    }
                    this.motionY += 0.007000000216066837;
                }
                double speedMultiplier = EntityBoatBase.field_speedMultiplier.getDouble(this);
                if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
                    final EntityLivingBase entitylivingbase = (EntityLivingBase) this.riddenByEntity;
                    final float f = this.riddenByEntity.rotationYaw + -entitylivingbase.moveStrafing * 90.0f;
                    this.motionX += -Math.sin(f * 3.1415927f / 180.0f) * speedMultiplier * entitylivingbase.moveForward * 0.05000000074505806 * this.getAccelerationFactor();
                    this.motionZ += Math.cos(f * 3.1415927f / 180.0f) * speedMultiplier * entitylivingbase.moveForward * 0.05000000074505806 * this.getAccelerationFactor();
                }
                double d4 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                if (d4 > this.getTopSpeed()) {
                    final double d5 = this.getTopSpeed() / d4;
                    this.motionX *= d5;
                    this.motionZ *= d5;
                    d4 = this.getTopSpeed();
                }
                if (d4 > d3 && speedMultiplier < 0.35) {
                    speedMultiplier += (0.35 - speedMultiplier) / 35.0;
                    if (speedMultiplier > 0.35) {
                        speedMultiplier = 0.35;
                    }
                }
                else {
                    speedMultiplier -= (speedMultiplier - 0.07) / 35.0;
                    if (speedMultiplier < 0.07) {
                        speedMultiplier = 0.07;
                    }
                }
                EntityBoatBase.field_speedMultiplier.setDouble(this, speedMultiplier);
                for (int l = 0; l < 4; ++l) {
                    final int i2 = MathHelper.floor_double(this.posX + (l % 2 - 0.5) * 0.8);
                    final int j = MathHelper.floor_double(this.posZ + (l / 2 - 0.5) * 0.8);
                    for (int j2 = 0; j2 < 2; ++j2) {
                        final int k = MathHelper.floor_double(this.posY) + j2;
                        final Block block = this.worldObj.getBlock(i2, k, j);
                        if (block == Blocks.snow_layer) {
                            this.worldObj.setBlockToAir(i2, k, j);
                            this.isCollidedHorizontally = false;
                        }
                        else if (block == Blocks.waterlily) {
                            this.worldObj.func_147480_a(i2, k, j, true);
                            this.isCollidedHorizontally = false;
                        }
                    }
                }
                if (this.onGround) {
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                }
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                if (this.isCollidedHorizontally && d3 > this.getBreakMotion()) {
                    if (!this.worldObj.isRemote && !this.isDead) {
                        this.setDead();
                        this.breakBoat(d3);
                    }
                }
                else {
                    this.motionX *= 0.9900000095367432;
                    this.motionY *= 0.949999988079071;
                    this.motionZ *= 0.9900000095367432;
                }
                this.rotationPitch = 0.0f;
                double d5 = this.rotationYaw;
                final double d10 = this.prevPosX - this.posX;
                final double d11 = this.prevPosZ - this.posZ;
                if (d10 * d10 + d11 * d11 > 0.001) {
                    d5 = (float) (Math.atan2(d11, d10) * 180.0 / 3.141592653589793);
                }
                double d12 = MathHelper.wrapAngleTo180_double(d5 - this.rotationYaw);
                if (d12 > 20.0) {
                    d12 = 20.0;
                }
                if (d12 < -20.0) {
                    d12 = -20.0;
                }
                this.setRotation(this.rotationYaw += (float) d12, this.rotationPitch);
                if (!this.worldObj.isRemote) {
                    final List<Entity> list = (List<Entity>) this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224, 0.0, 0.20000000298023224));
                    if (list != null && !list.isEmpty()) {
                        for (final Entity entity : list) {
                            if (entity != this.riddenByEntity && entity.canBePushed() && entity instanceof EntityBoat) {
                                entity.applyEntityCollision(this);
                            }
                        }
                    }
                    if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                        this.riddenByEntity = null;
                    }
                }
            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityItem func_145778_a(Item item, int meta, float yOffset) {
        if (item == Items.boat) {
            return this.entityDropItem(this.getItem(), yOffset);
        }
        return super.func_145778_a(item, meta, yOffset);
    }

    public abstract String getTexture();

    public ItemStack getPickedResult(MovingObjectPosition target) {
        return this.getItem();
    }

    protected ItemStack getItem() {
        return new ItemStack(Items.boat);
    }

    protected double getBreakMotion() {
        return 0.2;
    }

    protected void breakBoat(double motion) {
        for (int k = 0; k < 3; ++k) {
            this.entityDropItem(new ItemStack(Blocks.planks), 0.0f);
        }
        for (int k = 0; k < 2; ++k) {
            this.entityDropItem(new ItemStack(Items.stick), 0.0f);
        }
    }

    protected double getAccelerationFactor() {
        return 1.0;
    }

    protected double getTopSpeed() {
        return 0.35;
    }

    protected boolean isOnWater(AxisAlignedBB aabb) {
        return this.worldObj.isAABBInMaterial(aabb, Material.water);
    }
}
