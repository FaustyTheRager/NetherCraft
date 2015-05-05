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
    public static BlockOreBase         fouliteOre;
    public static BlockOreBase         liniumOre;
    public static BlockOreBase         neridiumOre;
    public static BlockOreBase         pyridiumOre;
    public static BlockOreBase         mourningOre;
    public static BlockNetherWorkbench netherCraftingTable;
    //public static BlockSoulGlass  soulGlass;

    public static void create() {
        mourningOre = new BlockOreBase("mourning_ore");
        fouliteOre = new BlockOreBase("foulite_ore");
        liniumOre = new BlockOreBase("linium_ore");
        neridiumOre = new BlockOreBase("neridium_ore");
        pyridiumOre = new BlockOreBase("pyridium_ore");
        netherDirt = new BlockBase("nether_dirt", Material.ground, Block.soundTypeGravel);
        glowWood = new BlockGlowBase("glow_wood");
        glowWoodPlank = new BlockGlowBase("glow_wood_plank");
        //soulGlass = new BlockBase("soul_glass", Material.glass, Block.soundTypeGlass);
        fieryStone = new BlockFieryStone();
        fieryCobblestone = new BlockBase("fiery_cobblestone", Material.rock, Block.soundTypeStone);
        netherCraftingTable = new BlockNetherWorkbench();
    }

}
