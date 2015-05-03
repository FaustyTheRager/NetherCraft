package com.fausty.nethercraft;

import com.fausty.nethercraft.NetherCraft;
import com.fausty.nethercraft.entity.EntityBoatBase;
import com.fausty.nethercraft.entity.EntityLavaBoat;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void create() {
        EntityBoatBase.init();
        EntityRegistry.registerModEntity(EntityLavaBoat.class, "LavaBoat", 1, NetherCraft.instance, 80, 3, true);
    }

}
