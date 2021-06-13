package com.vgfreak.test.registry;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class SapphireToolMaterial implements ToolMaterial {

                /*
            mining level, durability, mining speed, atk dmg, enchant
            3, 1561, 8.0F, 3.0F, 10,
             */


    //1541 is base diamond
    @Override
    public int getDurability() {
        return 2048;
    }

    //8.0F is base diamond
    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    //6F is base diamond
    @Override
    public float getAttackDamage() {
        return 4.0F;
    }

    //3+ is equivalent to mining level obsidian
    @Override
    public int getMiningLevel() {
        return 4;
    }

    //10 for diamond, 22 for gold
    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.SAPPHIRE);
    }
}
