package com.fausty.nethercraft.block;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.ModItems;
import com.fausty.nethercraft.block.base.BlockOreBase;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockNetherOre extends BlockOreBase {

    public BlockNetherOre(String internalName) {
        super(internalName);
    }

    public Item getItemDropped(int i, Random random, int k) {
        return this == ModBlocks.fouliteOre ? ModItems.fouliteDust : (this == ModBlocks.mourningOre ? ModItems.tearDust : Item.getItemFromBlock(this));
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int getExpDrop(IBlockAccess blockAccess, int i, int k) {
        if (this.getItemDropped(i, this.random, k) != Item.getItemFromBlock(this)) {
            int xp = 0;
            if (this == ModBlocks.fouliteOre || this == ModBlocks.liniumOre || this == ModBlocks.mourningOre || this == ModBlocks.neridiumOre || this == ModBlocks.pyridiumOre) {
                xp = MathHelper.getRandomIntegerInRange(this.random, 0, 2);
            }
            return xp;
        }
        return 0;
    }

}
