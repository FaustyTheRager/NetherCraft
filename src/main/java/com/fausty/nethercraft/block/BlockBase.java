package com.fausty.nethercraft.block;

import com.fausty.nethercraft.tab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(String internalName, Material material) {
        super(material);
        this.setBlockName(internalName);
        this.setBlockTextureName("nethercraft:" + internalName);
        this.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerBlock(this, internalName);
    }

    public BlockBase(String internalName, Material material, SoundType sound) {
        this(internalName, material);
        this.setStepSound(sound);
    }

}
