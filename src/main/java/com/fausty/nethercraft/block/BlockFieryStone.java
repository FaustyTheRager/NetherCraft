package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockFieryStone extends BlockBase {

    public BlockFieryStone() {
        super("fiery_stone", Material.rock, Block.soundTypeStone);
        setLightLevel(1.0F);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.fieryCobblestone);
    }
}
