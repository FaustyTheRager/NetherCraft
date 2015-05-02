package com.fausty.nethercraft;

import com.fausty.nethercraft.block.BlockBase;
import com.fausty.nethercraft.tab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static final BlockBase testBlock  = new BlockBase(Material.rock);
    public static final BlockBase netherDirt = new BlockBase(Material.ground);
    public static final BlockBase glowWood = new BlockBase(Material.wood);

    public static void create() {
        testBlock.setBlockName("test_block");                   // Creation of testBlock
        testBlock.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(testBlock, "Test Block");

        netherDirt.setBlockName("netherDirt");                  // Creation of netherDirt
        netherDirt.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(netherDirt, "Nether Dirt");


        glowWood.setBlockName("glowWood");                   // Creation of testBlock
        glowWood.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(glowWood, "Glow Wood");
    }

}
