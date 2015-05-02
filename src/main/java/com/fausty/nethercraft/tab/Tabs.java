package com.fausty.nethercraft.tab;

import com.fausty.nethercraft.NetherCraft;
import com.fausty.nethercraft.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tabs {

    public static final CreativeTabs NETHERCRAFT = new CreativeTabs(NetherCraft.MODID) {
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.testBlock);
        }
    };

}
