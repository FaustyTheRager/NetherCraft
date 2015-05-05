package com.fausty.nethercraft.block.tileentity;

import com.fausty.nethercraft.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileInventory extends TileEntity implements IInventory {

    private ItemStack[] contents;
    private String      inventoryName;
    private String      customName;
    private int         maxStackSize;

    protected TileInventory(String inventoryName, int slots, int maxStackSize) {
        this.inventoryName = inventoryName;
        this.maxStackSize = maxStackSize;
        this.contents = new ItemStack[slots];
    }

    public int getSizeInventory() {
        return this.contents.length;
    }

    public ItemStack[] getContents() {
        return this.contents;
    }

    public ItemStack getStackInSlot(int slotIndex) {
        return contents[slotIndex];
    }

    public ItemStack decrStackSize(int slotIndex, int toRemove) {
        if (this.contents[slotIndex] != null) {
            ItemStack itemstack;

            if (this.contents[slotIndex].stackSize <= toRemove) {
                itemstack = this.contents[slotIndex];
                this.contents[slotIndex] = null;
                this.markDirty();
                return itemstack;
            }
            else {
                itemstack = this.contents[slotIndex].splitStack(toRemove);

                if (this.contents[slotIndex].stackSize == 0) {
                    this.contents[slotIndex] = null;
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
        if (this.contents[slotIndex] != null) {
            ItemStack itemstack = this.contents[slotIndex];
            this.contents[slotIndex] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
        this.contents[slotIndex] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : inventoryName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void readFromNBT(NBTTagCompound tags) {
        super.readFromNBT(tags);
        NBTTagList list = tags.getTagList("items", 10);
        this.contents = new ItemStack[getSizeInventory()];

        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound nbt = list.getCompoundTagAt(i);
            int j = nbt.getByte("slot");

            if (j >= 0 && j < this.contents.length) {
                this.contents[j] = ItemStack.loadItemStackFromNBT(nbt);
            }
        }
    }

    public void writeToNBT(NBTTagCompound tags) {
        super.writeToNBT(tags);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.contents.length; ++i) {
            if (this.contents[i] != null) {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setByte("slot", (byte) i);
                this.contents[i].writeToNBT(nbt);
                list.appendTag(nbt);
            }
        }

        tags.setTag("items", list);
    }

    public int getInventoryStackLimit() {
        return this.maxStackSize;
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
