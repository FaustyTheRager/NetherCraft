package com.fausty.nethercraft.proxy;

import com.fausty.nethercraft.block.tileentity.TileNetherWorkbench;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy {

    public CommonProxy() {
        GameRegistry.registerTileEntity(TileNetherWorkbench.class, "nether_workbench");
    }

    public EntityPlayer getPlayerInstance() {
        return null;
    }

}
