package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.GT_Values.MOD_ID_GTPP;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.loaders.postload.GT_MachineRecipeLoader.isEBXLLoaded;
import static gregtech.loaders.postload.GT_MachineRecipeLoader.isRailcraftLoaded;

import mods.railcraft.common.blocks.aesthetics.cube.EnumCube;
import mods.railcraft.common.items.RailcraftToolItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.loaders.postload.GT_MachineRecipeLoader;

public class CompressorRecipes implements Runnable {

    @Override
    public void run() {
        GT_ModHandler.addCompressionRecipe(
                getModItem(MOD_ID_GTPP, "blockRainforestOakSapling", 8, 0),
                ItemList.IC2_Plantball.get(1));

        GT_Values.RA.addCompressorRecipe(
                ItemList.IC2_Compressed_Coal_Chunk.get(1L),
                ItemList.IC2_Industrial_Diamond.get(1L),
                300,
                2);
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
                GT_ModHandler.getIC2Item("Uran238", 1L));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L),
                GT_ModHandler.getIC2Item("Uran235", 1L));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
                GT_ModHandler.getIC2Item("Plutonium", 1L));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L),
                GT_ModHandler.getIC2Item("smallUran235", 1L));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium, 1L),
                GT_ModHandler.getIC2Item("smallPlutonium", 1L));
        GT_ModHandler.addCompressionRecipe(new ItemStack(Blocks.ice, 2, 32767), new ItemStack(Blocks.packed_ice, 1, 0));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                new ItemStack(Blocks.ice, 1, 0));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 4L),
                getModItem(GT_MachineRecipeLoader.aTextAE, "tile.BlockQuartz", 1L));
        GT_ModHandler.addCompressionRecipe(
                getModItem(GT_MachineRecipeLoader.aTextAE, GT_MachineRecipeLoader.aTextAEMM, 8L, 10),
                getModItem(GT_MachineRecipeLoader.aTextAE, "tile.BlockQuartz", 1L));
        GT_ModHandler.addCompressionRecipe(
                getModItem(GT_MachineRecipeLoader.aTextAE, GT_MachineRecipeLoader.aTextAEMM, 8L, 11),
                new ItemStack(Blocks.quartz_block, 1, 0));
        GT_ModHandler.addCompressionRecipe(
                getModItem(GT_MachineRecipeLoader.aTextAE, GT_MachineRecipeLoader.aTextAEMM, 8L, 12),
                getModItem(GT_MachineRecipeLoader.aTextAE, "tile.BlockFluix", 1L));
        GT_ModHandler.addCompressionRecipe(new ItemStack(Items.quartz, 4, 0), new ItemStack(Blocks.quartz_block, 1, 0));
        // GT_ModHandler.addCompressionRecipe(new ItemStack(Items.wheat, 9, 0), new ItemStack(Blocks.hay_block, 1, 0));
        GT_ModHandler.addCompressionRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4L),
                new ItemStack(Blocks.glowstone, 1));

        GT_Values.RA.addCompressorRecipe(Materials.Fireclay.getDust(1), ItemList.CompressedFireclay.get(1), 80, 4);
        GameRegistry.addSmelting(ItemList.CompressedFireclay.get(1), ItemList.Firebrick.get(1), 0);

        if (isEBXLLoaded) {
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 0),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 1),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 2),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 3),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 4),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 5),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 6),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_1", 4, 7),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_2", 4, 0),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_2", 4, 1),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_2", 4, 2),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_2", 4, 3),
                    ItemList.IC2_Plantball.get(1));
            GT_ModHandler.addCompressionRecipe(
                    getModItem(GT_MachineRecipeLoader.aTextEBXL, "saplings_2", 4, 4),
                    ItemList.IC2_Plantball.get(1));
        }
        if (isRailcraftLoaded) {
            GT_Values.RA.addCompressorRecipe(RailcraftToolItems.getCoalCoke(9), EnumCube.COKE_BLOCK.getItem(), 300, 2);
        }
    }
}
