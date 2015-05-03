package com.fausty.nethercraft.gui;

import com.fausty.nethercraft.block.tileentity.TileInventory;
import com.fausty.nethercraft.container.ContainerNetherWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiNetherWorkbench extends GuiContainer {

    public static final int guiID = 1;

    private ResourceLocation guiTexture = new ResourceLocation("textures/gui/container/crafting_table.png");

    public GuiNetherWorkbench(InventoryPlayer inventory, TileInventory tileEntity) {
        super(new ContainerNetherWorkbench(inventory, tileEntity));
        xSize = 176;
        ySize = 166;
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        fontRendererObj.drawString(StatCollector.translateToLocal("container.nether_workbench"), 28, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
