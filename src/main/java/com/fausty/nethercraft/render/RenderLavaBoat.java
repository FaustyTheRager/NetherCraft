package com.fausty.nethercraft.render;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLavaBoat extends RenderBoat {

    protected ResourceLocation getEntityTexture(final EntityBoat entity) {
        return new ResourceLocation("nethercraft", ((EntityLavaBoat) entity).getTexture());
    }

}
