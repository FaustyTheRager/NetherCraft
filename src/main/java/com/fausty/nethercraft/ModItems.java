package com.fausty.nethercraft;

import com.fausty.nethercraft.item.ItemBase;
import com.fausty.nethercraft.item.ItemLavaBoat;

public class ModItems {

    public static ItemLavaBoat lavaBoat;
    public static ItemBase     fouliteDust;

    public static void create() {
        lavaBoat = new ItemLavaBoat("lava_boat");
        fouliteDust = new ItemBase("foulite_dust");
    }

}
