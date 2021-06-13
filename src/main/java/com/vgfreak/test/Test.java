package com.vgfreak.test;

import com.vgfreak.test.registry.ModBlocks;
import com.vgfreak.test.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Test implements ModInitializer {

    public static final String MOD_ID = "test";

    @Override
    public void onInitialize() {

        ModItems.registerItems();
        ModBlocks.registerBlocks();

    }

}
