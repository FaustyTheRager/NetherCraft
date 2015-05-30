package com.fausty.nethercraft.tab.crafting;

import com.fausty.nethercraft.ModBlocks;
import com.fausty.nethercraft.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class NethercraftBoatRecipe {

    public NethercraftBoatRecipe()
    {

        ItemStack glowWoodPlankStack = new ItemStack(ModBlocks.glowWoodPlank);

        GameRegistry.addRecipe(new ItemStack(ModItems.lavaBoat))
                "   ",
                "X X",
                "XXX",
                'X', glowWoodPlankStack);

    }

}
