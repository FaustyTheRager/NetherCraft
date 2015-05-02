package com.fausty.nethercraft.entity;

import com.fausty.nethercraft.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLavaBoat extends EntityBoatBase {

    public EntityLavaBoat(World world) {
        super(world);
    }

    protected ItemStack getItem() {
        return new ItemStack(ModItems.lavaBoat);
    }

    protected double getBreakMotion() {
        return 0.5;
    }

    protected void breakBoat(final double motion) {
        this.entityDropItem(this.getItem(), 0.0f);
    }

    protected double getAccelerationFactor() {
        return 1.5;
    }

    protected double getTopSpeed() {
        return 0.9;
    }

    protected boolean isOnWater(final AxisAlignedBB aabb) {
        return this.worldObj.isAABBInMaterial(aabb, Material.water) || this.worldObj.isAABBInMaterial(aabb, Material.lava);
    }

    public String getTexture() {
        return "textures/models/lavaBoat.png";
    }

}
