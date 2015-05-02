package com.fausty.nethercraft.entity;

import com.fausty.nethercraft.NetherCraft;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

    public static void create() {
        EntityBoatBase.init();
        EntityRegistry.registerModEntity(EntityLavaBoat.class, "LavaBoat", 1, NetherCraft.instance, 80, 3, true);
    }

}
