package com.fausty.nethercraft;

import com.fausty.nethercraft.item.ItemBase;
import com.fausty.nethercraft.item.ItemLavaBoat;

public class ModItems {

    public static ItemLavaBoat lavaBoat;
    public static ItemBase foulite;

    public static void create() {
        lavaBoat = new ItemLavaBoat("lava_boat");
        foulite = new ItemBase("foulite");
    }

}
