package com.fausty.nethercraft;

import com.fausty.nethercraft.block.*;
import com.fausty.nethercraft.block.base.BlockBase;
import com.fausty.nethercraft.block.base.BlockGlowBase;
import com.fausty.nethercraft.block.base.BlockOreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static BlockBase            netherDirt;
    public static BlockGlowBase        glowWood;
    public static BlockGlowBase        glowWoodPlank;
    public static BlockFieryStone      fieryStone;
    public static BlockBase            fieryCobblestone;
    public static BlockNetherOre         fouliteOre;
    public static BlockNetherOre         liniumOre;
    public static BlockNetherOre         neridiumOre;
    public static BlockNetherOre         pyridiumOre;
    public static BlockNetherOre         mourningOre;
    public static BlockNetherWorkbench netherCraftingTable;
    //public static BlockSoulGlass  soulGlass;

    public static void create() {
        mourningOre = new BlockNetherOre("mourning_ore");
        fouliteOre = new BlockNetherOre("foulite_ore");
        liniumOre = new BlockNetherOre("linium_ore");
        neridiumOre = new BlockNetherOre("neridium_ore");
        pyridiumOre = new BlockNetherOre("pyridium_ore");
        netherDirt = new BlockBase("nether_dirt", Material.ground, Block.soundTypeGravel, 0.5F);
        glowWood = new BlockGlowBase("glow_wood", Material.wood);
        glowWoodPlank = new BlockGlowBase("glow_wood_plank", Material.wood);
        //soulGlass = new BlockBase("soul_glass", Material.glass, Block.soundTypeGlass);
        fieryStone = new BlockFieryStone();
        fieryCobblestone = new BlockBase("fiery_cobblestone", Material.rock, Block.soundTypeStone, 2.0F);
        netherCraftingTable = new BlockNetherWorkbench();
    }

}
