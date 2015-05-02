package com.fausty.nethercraft.entity;

import com.fausty.nethercraft.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLavaBoat extends EntityBoatBase {

    public EntityLavaBoat(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    protected ItemStack getItem() {
        return new ItemStack(ModItems.lavaBoat);
    }

    protected double getBreakMotion() {
        return 0.7;
    }

    protected void breakBoat(double motion) {
        this.entityDropItem(this.getItem(), 0.0f);
    }

    protected double getAccelerationFactor() {
        return 1.5;
    }

    protected double getTopSpeed() {
        return 0.9;
    }

    protected boolean isOnWater(AxisAlignedBB aabb) {
        return this.worldObj.isAABBInMaterial(aabb, Material.water) || this.worldObj.isAABBInMaterial(aabb, Material.lava);
    }

    public String getTexture() {
        return "textures/models/lava_boat.png";
    }

    public boolean canBePushed() {
        return false;
    }

    public void onUpdate() {
        this.extinguish();
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
            this.riddenByEntity.extinguish();
            DataWatcher watcher = riddenByEntity.getDataWatcher();
            if (!getFlag(2)) {
                watcher.updateObject(0, Byte.valueOf((byte) 0));
            }
        }
        super.onUpdate();
        if (this.riddenByEntity == null) {
            this.motionX = 0;
            this.motionZ = 0;
        }
    }

}
