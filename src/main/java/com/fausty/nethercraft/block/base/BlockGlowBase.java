package com.fausty.nethercraft.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowBase extends BlockBase {

    public BlockGlowBase(String internalName, Material material) {
        this(internalName, material, Block.soundTypeWood, 2.0F);
    }

    public BlockGlowBase(String internalName, Material material, SoundType soundType, float hardness) {
        super(internalName, material, soundType, hardness);
        this.setLightLevel(0.6F);
        this.setResistance(5.0F);
    }

}
