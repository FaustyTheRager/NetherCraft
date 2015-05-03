package com.fausty.nethercraft.block.tileentity;

import net.minecraft.item.ItemStack;

public class TileNetherWorkbench extends TileInventory {

    public TileNetherWorkbench() {
        super();
        contents = new ItemStack[9];
        inventoryName = "container.nether_workbench";
        maxStackSize = 64;
    }

}
