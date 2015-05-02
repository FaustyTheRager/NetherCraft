package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOreBase extends BlockOre {
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == ModBlocks.foulite_ore ? Items.foulite : (this == Blocks.diamond_ore ? Items.diamond : (this == Blocks.lapis_ore ? Items.dye : (this == Blocks.emerald_ore ? Items.emerald : (this == Blocks.quartz_ore ? Items.quartz : Item.getItemFromBlock(this)))));
    }
}
