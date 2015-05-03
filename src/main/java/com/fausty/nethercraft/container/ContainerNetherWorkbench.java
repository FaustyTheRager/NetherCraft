package com.fausty.nethercraft.container;

import com.fausty.nethercraft.block.tileentity.TileInventory;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerNetherWorkbench extends ContainerTile {

    public IInventory craftResult;

    public ContainerNetherWorkbench(InventoryPlayer inventory, TileInventory tile) {
        craftResult = new InventoryCraftResult();

        tileEntity = tile;

        addSlotToContainer(new SlotCrafting(inventory.player, tileEntity, craftResult, 0, 124, 35));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                addSlotToContainer(new Slot(tileEntity, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }

        slotsChanged();
    }

    public void slotsChanged() {
        InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
        for (int i = 0; i < tileEntity.getContents().length; i++) {
            craftMatrix.setInventorySlotContents(i, tileEntity.getContents()[i]);
        }
        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(craftMatrix, tileEntity.getWorldObj()));
    }

}
