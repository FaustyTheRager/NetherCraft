package com.fausty.nethercraft.render;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderLavaBoat extends Render {

    private static final ResourceLocation boatTextures = new ResourceLocation("textures/entity/boat.png");
    protected ModelBase modelBoat;

    public RenderLavaBoat() {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
    }

    public void doRender(EntityLavaBoat entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
        float f2 = (float)entity.getTimeSinceHit() - p_76986_9_;
        float f3 = entity.getDamageTaken() - p_76986_9_;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)entity.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(entity);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityLavaBoat p_110775_1_)
    {
        return boatTextures;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityLavaBoat)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityLavaBoat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

}
