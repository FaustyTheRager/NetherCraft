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
        RenderingRegistry.registerEntityRenderingHandler(EntityLavaBoat.class, new RenderLavaBoat());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()) {
            EntityPlayer player = getPlayerInstance();
            DataWatcher watcher = player.getDataWatcher();
            if (player.ridingEntity != null && player.ridingEntity instanceof EntityLavaBoat) {
                EntityLavaBoat boat = (EntityLavaBoat) player.ridingEntity;
                boat.riddenByEntity = null;
                try {
                    Field field = Entity.class.getDeclaredField("isImmuneToFire");
                    field.setAccessible(true);
                    field.setBoolean(player, false);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            watcher.updateObject(0, Byte.valueOf((byte) 0));
        }
    }

    public EntityPlayer getPlayerInstance() {
        return Minecraft.getMinecraft().thePlayer;
    }

}
