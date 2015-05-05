package com.fausty.nethercraft.block.base;

import com.fausty.nethercraft.NetherCraft;
import com.fausty.nethercraft.block.tileentity.TileInventory;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class BlockContainerBase extends BlockBase implements ITileEntityProvider {

    protected BlockContainerBase(String internalName, Material material) {
        super(internalName, material, 2.5F);
        this.isBlockContainer = true;
    }

    public abstract int getGuiID();

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c, float d) {
        if (world.isRemote) {
            return true;
        }

        if (!player.isSneaking()) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity != null && tileEntity instanceof TileInventory) {
                player.openGui(NetherCraft.instance, getGuiID(), world, x, y, z);
                return true;
            }
        }
        return false;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        int direction = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (direction == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (direction == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (direction == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (stack.hasDisplayName()) {
            ((TileEntityFurnace) world.getTileEntity(x, y, z)).func_145951_a(stack.getDisplayName());
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metaData) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileInventory) {
            ItemStack[] contents = ((TileInventory) tileEntity).getContents();
            for (ItemStack stack : contents) {
                if (stack != null) {
                    world.spawnEntityInWorld(new EntityItem(world, (double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, stack));
                }
            }
        }
        super.breakBlock(world, x, y, z, block, metaData);
        world.removeTileEntity(x, y, z);
    }

    public boolean onBlockEventReceived(World world, int x, int y, int z, int i, int k) {
        super.onBlockEventReceived(world, x, y, z, i, k);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(i, k);
    }

}
