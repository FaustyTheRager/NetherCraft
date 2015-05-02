package com.fausty.nethercraft.block;

import com.fausty.nethercraft.entity.EntityLavaBoat;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockBase extends Block {

    public BlockBase(Material material) {
        super(material);
    }

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        EntityLavaBoat entityBoat = new EntityLavaBoat(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
        world.spawnEntityInWorld(entityBoat);
    }
}
