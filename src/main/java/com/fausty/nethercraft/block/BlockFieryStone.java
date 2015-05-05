package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.block.base.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockFieryStone extends BlockBase {

    public BlockFieryStone() {
        super("fiery_stone", Material.rock, Block.soundTypeStone, 2.0F);
        setLightLevel(1.0F);
    }

    public Item getItemDropped(int i, Random random, int k) {
        return Item.getItemFromBlock(ModBlocks.fieryCobblestone);
    }
}
