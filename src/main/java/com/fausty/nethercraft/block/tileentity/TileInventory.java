package com.fausty.nethercraft.block.tileentity;

import com.fausty.nethercraft.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileInventory extends TileEntity implements IInventory {

    protected ItemStack[] contents;
    protected String      inventoryName;
    protected int         maxStackSize;

    public int getSizeInventory() {
        return contents.length;
    }

    public ItemStack[] getContents() {
        return contents;
    }

    public ItemStack getStackInSlot(int slotIndex) {
        return contents[slotIndex];
    }

    public ItemStack decrStackSize(int slotIndex, int toRemove) {
        if (contents[slotIndex] != null) {
            ItemStack itemstack;

            if (contents[slotIndex].stackSize <= toRemove) {
                itemstack = contents[slotIndex];
                contents[slotIndex] = null;
                this.markDirty();
                return itemstack;
            }
            else {
                itemstack = contents[slotIndex].splitStack(toRemove);

                if (contents[slotIndex].stackSize == 0) {
                    contents[slotIndex] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        if (contents[slotIndex] != null) {
            ItemStack itemstack = contents[slotIndex];
            contents[slotIndex] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
        contents[slotIndex] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void readFromNBT(NBTTagCompound tags) {
        super.readFromNBT(tags);
        NBTTagList list = tags.getTagList("items", 10);
        contents = new ItemStack[getSizeInventory()];

        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound nbt = list.getCompoundTagAt(i);
            int j = nbt.getByte("slot");

            if (j >= 0 && j < contents.length) {
                contents[j] = ItemStack.loadItemStackFromNBT(nbt);
            }
        }
    }

    public void writeToNBT(NBTTagCompound tags) {
        super.writeToNBT(tags);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < contents.length; ++i) {
            if (contents[i] != null) {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setByte("slot", (byte) i);
                contents[i].writeToNBT(nbt);
                list.appendTag(nbt);
            }
        }

        tags.setTag("items", list);
    }

    public boolean hasCustomInventoryName() {
        return false;
    }

    public int getInventoryStackLimit() {
        return maxStackSize;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord) == ModBlocks.netherCraftingTable && player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {
    }

    public void closeInventory() {
    }

    public boolean isItemValidForSlot(int slotIndex, ItemStack stack) {
        return true;
    }

}
