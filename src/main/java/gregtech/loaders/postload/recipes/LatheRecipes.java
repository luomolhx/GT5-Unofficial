package gregtech.loaders.postload.recipes;

import static gregtech.api.util.GT_ModHandler.getModItem;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.loaders.postload.GT_MachineRecipeLoader;

public class LatheRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addLatheRecipe(
                new ItemStack(Blocks.wooden_slab, 1, GT_Values.W),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
        GT_Values.RA.addLatheRecipe(
                getModItem(GT_MachineRecipeLoader.aTextForestry, "slabs", 1L, GT_Values.W),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
        GT_Values.RA.addLatheRecipe(
                getModItem(GT_MachineRecipeLoader.aTextEBXL, "woodslab", 1L, GT_Values.W),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
    }
}
