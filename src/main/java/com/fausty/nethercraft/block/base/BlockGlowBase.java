package com.fausty.nethercraft.block.base;

import com.fausty.nethercraft.block.base.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowBase extends BlockBase {

    public BlockGlowBase(String internalName) {
        super(internalName, Material.wood, Block.soundTypeWood);
        setLightLevel(1.0F);
    }

}
