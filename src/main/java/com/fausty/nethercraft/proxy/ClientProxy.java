package com.fausty.nethercraft.proxy;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import com.fausty.nethercraft.render.RenderLavaBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.lang.reflect.Field;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        RenderingRegistry.registerEntityRenderingHandler(EntityLavaBoat.class, new RenderLavaBoat());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()) {
            EntityPlayer player = getPlayerInstance();
            player.extinguish();
            if (player.ridingEntity != null && player.ridingEntity instanceof EntityLavaBoat) {
                EntityLavaBoat boat = (EntityLavaBoat) player.ridingEntity;
                boat.riddenByEntity = null;
                player.setPositionAndUpdate(boat.posX, boat.posY + 5, boat.posZ);
            }
        }
    }

    public EntityPlayer getPlayerInstance() {
        return Minecraft.getMinecraft().thePlayer;
    }

}
