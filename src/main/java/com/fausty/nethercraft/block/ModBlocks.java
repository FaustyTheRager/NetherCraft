package com.fausty.nethercraft.block;

import com.fausty.nethercraft.creativetab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static final BlockBase testBlock = new BlockBase(Material.rock);

    public static final BlockBase netherDirt = new BlockBase(Material.dirt);

    public static void create() {
        testBlock.setBlockName("test_block");                   // Creation of testBlock
        testBlock.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(testBlock, "Test Block");
        
        netherDirt.setBlockName("netherDirt");
        netherDirt.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(netherDirt, "Nether Dirt");
    }

}
