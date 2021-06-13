package com.vgfreak.test.registry;

import com.vgfreak.test.Test;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .strength(5.0F, 6.0F)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL));

    public static final Block SAPPHIRE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
            .strength(3.0F, 3.0F)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Test.MOD_ID, "sapphire_block"), SAPPHIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Test.MOD_ID, "sapphire_ore"), SAPPHIRE_ORE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.MISC)));
    }


}
