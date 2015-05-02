package com.fausty.nethercraft.proxy;

import com.fausty.nethercraft.entity.EntityBoatBase;
import com.fausty.nethercraft.render.RenderLavaBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBoatBase.class, new RenderLavaBoat());
    }

}
