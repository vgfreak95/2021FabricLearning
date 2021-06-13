package com.vgfreak.test.registry;

import com.vgfreak.test.Test;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.heightprovider.HeightProviderType;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

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

    //Setup Generation of ore in overworld
    private static ConfiguredFeature<?, ?> ORE_SAPPHIRE_OVERWORLDD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    SAPPHIRE_ORE.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    UniformHeightProvider.create(
                            YOffset.fixed(0),
                            YOffset.fixed(14)))))
            .spreadHorizontally()
            .repeat(20); // number of veins per chunk



    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Test.MOD_ID, "sapphire_block"), SAPPHIRE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Test.MOD_ID, "sapphire_ore"), SAPPHIRE_ORE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.MISC)));
    }

    public static void generateOres() {
        RegistryKey<ConfiguredFeature<?, ?>> oreSapphireOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Test.MOD_ID, "ore_sapphire_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSapphireOverworld.getValue(), ORE_SAPPHIRE_OVERWORLDD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSapphireOverworld);
    }


}
