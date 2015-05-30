package com.fausty.nethercraft.block.base;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockGlassBase extends BlockBase {

    public BlockGlassBase(String internalName, Material material) {
        this(internalName, material, Block.soundTypeStone, 0.3F);
    }

    public BlockGlassBase(String internalName, Material material, SoundType soundType, float hardness) {
        super(internalName, material, soundType, hardness);
    }
    public boolean isOpaqueCube() { return false; }
}
