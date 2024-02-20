package pack.mirage.MKS.flint;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FlintMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 29;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.5f;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.FLINT);
    }

    @Override
    public String toString() {
        return "flint";
    }

}
