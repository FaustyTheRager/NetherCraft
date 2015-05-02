package com.fausty.nethercraft;

import com.fausty.nethercraft.block.ModBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NetherCraft.MODID, version = NetherCraft.VERSION)
public class NetherCraft {
    public static final String MODID   = "nethercraft";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.create();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

}
