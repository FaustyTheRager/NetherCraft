package com.fausty.nethercraft.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlassBase extends BlockConnectedTexturesBase {

    public BlockGlassBase(String internalName) {
        super(internalName, Material.glass, Block.soundTypeGlass, 0.3F, "soul_glass/side_");
        setLightOpacity(0);
        this.Falone = 0;
        this.Fjust1 = 1;
        this.Fcorner = 5;
        this.FinLine = 9;
        this.Fedge3 = 13;
        this.Fsurrounded = 17;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
}
