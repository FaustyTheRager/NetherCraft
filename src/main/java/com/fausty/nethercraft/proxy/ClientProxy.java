package com.fausty.nethercraft.proxy;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import com.fausty.nethercraft.render.RenderLavaBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        RenderingRegistry.registerEntityRenderingHandler(EntityLavaBoat.class, new RenderLavaBoat());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()) {

        }
    }

}
