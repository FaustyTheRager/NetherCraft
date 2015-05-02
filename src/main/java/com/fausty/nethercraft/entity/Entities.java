package com.fausty.nethercraft.entity;

import com.fausty.nethercraft.NetherCraft;
import com.fausty.nethercraft.render.RenderLavaBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

    public static void create() {
        EntityBoatBase.init();
        EntityRegistry.registerModEntity(EntityBoatBase.class, "LavaBoat", 1, NetherCraft.instance, 80, 3, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityBoatBase.class, new RenderLavaBoat());
    }

}
