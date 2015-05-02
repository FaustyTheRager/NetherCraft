package com.fausty.nethercraft;

import com.fausty.nethercraft.block.BlockBase;
import com.fausty.nethercraft.block.BlockFieryStone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static BlockBase       testBlock;
    public static BlockBase       netherDirt;
    public static BlockBase       glowWood;
    public static BlockBase       heatSand;
    public static BlockBase       heatGlass;
    public static BlockFieryStone fieryStone;
    public static BlockBase       fieryCobblestone;

    public static void create() {
        testBlock = new BlockBase("test_block", Material.rock);
        netherDirt = new BlockBase("nether_dirt", Material.ground, Block.soundTypeGravel);
        glowWood = new BlockBase("glow_wood", Material.rock, Block.soundTypeWood);
        heatSand = new BlockBase("heat_sand", Material.sand, Block.soundTypeSand);
        heatGlass = new BlockBase("heat_glass", Material.glass, Block.soundTypeGlass);
        fieryStone = new BlockFieryStone();
        fieryCobblestone = new BlockBase("fiery_cobblestone", Material.rock, Block.soundTypeStone);
    }

}
