package com.fausty.nethercraft.block.base;

import com.fausty.nethercraft.tab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(String internalName, Material material, float hardness) {
        super(material);
        this.setBlockName(internalName);
        this.setBlockTextureName("nethercraft:" + internalName);
        this.setCreativeTab(Tabs.NETHERCRAFT);
        this.setHardness(hardness);
        GameRegistry.registerBlock(this, internalName);
    }

    public BlockBase(String internalName, Material material, SoundType sound, float hardness) {
        this(internalName, material, hardness);
        this.setStepSound(sound);
    }

}
