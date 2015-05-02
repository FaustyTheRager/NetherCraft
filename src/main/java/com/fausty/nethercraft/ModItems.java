package com.fausty.nethercraft;

import com.fausty.nethercraft.item.ItemLavaBoat;

public class ModItems {

    public static ItemLavaBoat lavaBoat;

    public static void create() {
        lavaBoat = new ItemLavaBoat("lava_boat");
    }

}
