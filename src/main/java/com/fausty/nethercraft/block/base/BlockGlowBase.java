package com.fausty.nethercraft.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowBase extends BlockBase {

    public BlockGlowBase(String internalName, Material material) {
        this(internalName, material, 2.0F);
    }

    public BlockGlowBase(String internalName, Material material, float hardness) {
        super(internalName, material, Block.soundTypeWood);
        this.setLightLevel(0.6F);
        this.setHardness(hardness);
        this.setResistance(5.0F);
    }

}
