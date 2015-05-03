package com.fausty.nethercraft.container;

import com.fausty.nethercraft.block.tileentity.TileInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTile extends Container {

    protected TileInventory tileEntity;

    public void slotsChanged() {
    }

    public ItemStack slotClick(int slotIndex, int num1, int num2, EntityPlayer player) {
        ItemStack stack = super.slotClick(slotIndex, num1, num2, player);
        slotsChanged();
        return stack;
    }

    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotIndex == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotIndex >= 10 && slotIndex < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            }
            else if (slotIndex >= 37 && slotIndex < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            }
            else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

}
