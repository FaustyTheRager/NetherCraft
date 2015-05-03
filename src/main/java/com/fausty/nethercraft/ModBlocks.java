package com.fausty.nethercraft;

import com.fausty.nethercraft.block.BlockBase;
import com.fausty.nethercraft.block.BlockFieryStone;
import com.fausty.nethercraft.block.BlockGlowBase;
import com.fausty.nethercraft.block.BlockOreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static BlockBase       netherDirt;
    public static BlockGlowBase   glowWood;
    public static BlockFieryStone fieryStone;
    public static BlockBase       fieryCobblestone;
    public static BlockOreBase    fouliteOre;
    public static BlockOreBase    liniumOre;
    public static BlockOreBase    neridiumOre;
    public static BlockOreBase    pyridiumOre;
    public static BlockOreBase    wOre;
    //public static BlockSoulGlass  soulGlass;

    public static void create() {
        wOre= new BlockOreBase("w_ore");
        fouliteOre = new BlockOreBase("foulite_ore");
        liniumOre = new BlockOreBase("linium_ore");
        neridiumOre = new BlockOreBase("neridium_ore");
        pyridiumOre = new BlockOreBase("pyridium_ore");
        netherDirt = new BlockBase("nether_dirt", Material.ground, Block.soundTypeGravel);
        glowWood = new BlockGlowBase("glow_wood");
        //soulGlass = new BlockBase("soul_glass", Material.glass, Block.soundTypeGlass);
        fieryStone = new BlockFieryStone();
        fieryCobblestone = new BlockBase("fiery_cobblestone", Material.rock, Block.soundTypeStone);
    }

}
