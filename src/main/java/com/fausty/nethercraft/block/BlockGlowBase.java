package com.fausty.nethercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowBase extends BlockBase{

    public BlockGlowBase(){
        super("glow_base",Material.wood, Block.soundTypeWood);
        setLightLevel(1.0F);
    }

}
