package com.fausty.nethercraft.gui;

import com.fausty.nethercraft.block.tileentity.TileNetherWorkbench;
import com.fausty.nethercraft.container.ContainerNetherWorkbench;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case GuiNetherWorkbench.guiID:
                return new ContainerNetherWorkbench(player.inventory, (TileNetherWorkbench) tileEntity);
            default:
                return null;
        }

    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case GuiNetherWorkbench.guiID:
                return new GuiNetherWorkbench(player.inventory, (TileNetherWorkbench) tileEntity);
            default:
                return null;
        }
    }

}
