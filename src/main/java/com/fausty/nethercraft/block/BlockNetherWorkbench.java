package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.block.base.BlockContainerBase;
import com.fausty.nethercraft.block.tileentity.TileNetherWorkbench;
import com.fausty.nethercraft.gui.GuiNetherWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNetherWorkbench extends BlockContainerBase {

    private IIcon top;
    private IIcon side;
    private IIcon front;

    public BlockNetherWorkbench() {
        super("nether_workbench", Material.wood);
        this.setBlockTextureName("nethercraft:glow_wood");
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileNetherWorkbench();
    }

    public int getGuiID() {
        return GuiNetherWorkbench.guiID;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.top : (side == 0 ? ModBlocks.glowWoodPlank.getBlockTextureFromSide(side) : (side != 2 && side != 4 ? this.front : this.side));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.top = iconRegister.registerIcon("nethercraft:nether_workbench_top");
        this.side = iconRegister.registerIcon("nethercraft:nether_workbench_side");
        this.front = iconRegister.registerIcon("nethercraft:nether_workbench_front");
    }
}
