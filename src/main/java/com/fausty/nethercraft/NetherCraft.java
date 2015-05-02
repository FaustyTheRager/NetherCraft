package com.fausty.nethercraft;

import com.fausty.nethercraft.entity.Entities;
import com.fausty.nethercraft.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NetherCraft.MODID, version = NetherCraft.VERSION)
public class NetherCraft {
    public static final String MODID   = "nethercraft";
    public static final String VERSION = "1.0";

    @Instance(value = MODID)
    public static NetherCraft instance;
    @SidedProxy(clientSide = "com.fausty.nethercraft.proxy.ClientProxy", serverSide = "com.fausty.nethercraft.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.create();
        ModBlocks.create();
        Entities.create();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //MinecraftForge.EVENT_BUS.register(proxy);
    }

}
