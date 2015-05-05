package com.fausty.nethercraft.block.base;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public abstract class BlockOreBase extends BlockBase {

    protected Random random = new Random();

    protected BlockOreBase(String internalName) {
        this(internalName, 3.0F);
    }

    protected BlockOreBase(String internalName, float hardness) {
        super(internalName, Material.rock);
        this.setHardness(hardness);
        this.setResistance(5.0F);
    }

    public abstract Item getItemDropped(int i, Random random, int k);

    public abstract int quantityDropped(Random random);

    public abstract int getExpDrop(IBlockAccess blockAccess, int i, int k);

}
