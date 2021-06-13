package com.vgfreak.test.registry;

import com.vgfreak.test.Test;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.vgfreak.test.registry.SapphireToolMaterial;

public class ModItems {

    //Creates a new item in the registry called SAPPHIRE
    public static final Item SAPPHIRE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    //Reference an instance of sapphire
    public static final SapphireToolMaterial SAPPHIRE_MATERIAL = new SapphireToolMaterial();

    //Create the classes that extend each ItemType
    public static class SapphirePickaxeItem extends PickaxeItem {
        public SapphirePickaxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }
    }

    public static class SapphireAxeItem extends AxeItem {
        public SapphireAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }
    }

    public static class SapphireHoeItem extends HoeItem {
        public SapphireHoeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }
    }

    // Had to create Custom Sapphire Pickaxe Item extending Pickaxe Item because class is protected
    public static ToolItem SAPPHIRE_PICKAXE = new SapphirePickaxeItem(SAPPHIRE_MATERIAL, 2, -2.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem SAPPHIRE_AXE = new SapphireAxeItem(SAPPHIRE_MATERIAL, 4, -1.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem SAPPHIRE_SWORD = new SwordItem(SAPPHIRE_MATERIAL, 3, -1.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem SAPPHIRE_HOE = new SapphireHoeItem(SAPPHIRE_MATERIAL, 2, -1.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SAPPHIRE_MATERIAL, 2, -1.0F, new Item.Settings().group(ItemGroup.TOOLS));


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire"), SAPPHIRE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_axe"), SAPPHIRE_AXE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_sword"), SAPPHIRE_SWORD);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_hoe"), SAPPHIRE_HOE);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "sapphire_shovel"), SAPPHIRE_SHOVEL);
    }

}
