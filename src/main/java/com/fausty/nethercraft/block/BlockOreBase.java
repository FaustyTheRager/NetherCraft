package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.ModItems;
import com.fausty.nethercraft.tab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockOre;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOreBase extends BlockOre {

    public BlockOreBase(String internalName) {
        super();
        this.setBlockName(internalName);
        this.setBlockTextureName("nethercraft:" + internalName);
        this.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(this, internalName);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return this == ModBlocks.fouliteOre ? ModItems.fouliteDust : Item.getItemFromBlock(Blocks.stone);
        }

        }
