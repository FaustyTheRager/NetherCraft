package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.block.base.BlockContainerBase;
import com.fausty.nethercraft.block.tileentity.TileNetherWorkbench;
import com.fausty.nethercraft.gui.GuiNetherWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNetherWorkbench extends BlockContainerBase {

    private IIcon top;
    private IIcon side;
    private IIcon front;

    public BlockNetherWorkbench() {
        super("nether_workbench", Material.wood);
        this.setBlockTextureName("nethercraft:glow_wood");
        this.setLightLevel(0.6F);
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

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        for (int i = 0; i < 3; i++) {
            world.spawnParticle("portal", x + MathHelper.randomFloatClamp(random, -0.1F, 1.1F), y, z + MathHelper.randomFloatClamp(random, -0.1F, 1.1F), 0.0F, 0.4F, 0.0F);
        }
    }

}
