package com.fausty.nethercraft;

import com.fausty.nethercraft.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static BlockBase testBlock;
    public static BlockBase netherDirt;
    public static BlockBase glowWood;

    public static void create() {
        testBlock = new BlockBase("test_block", Material.rock);
        netherDirt = new BlockBase("nether_dirt", Material.ground);
        glowWood = new BlockBase("glow_wood", Material.rock, Block.soundTypeWood);
    }

}
