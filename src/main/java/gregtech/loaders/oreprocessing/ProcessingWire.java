package gregtech.loaders.oreprocessing;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBenderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBoxinatorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sUnboxinatorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sWiremillRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_Utility.calculateRecipeEU;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import appeng.api.config.TunnelType;
import appeng.core.Api;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Proxy;

public class ProcessingWire implements gregtech.api.interfaces.IOreRecipeRegistrator {

    private final Materials[] dielectrics = { Materials.PolyvinylChloride, Materials.Polydimethylsiloxane };
    private final Materials[] syntheticRubbers = { Materials.StyreneButadieneRubber, Materials.Silicone };

    private static Object tt;

    public ProcessingWire() {
        OrePrefixes.wireGt01.add(this);
        OrePrefixes.wireGt02.add(this);
        OrePrefixes.wireGt04.add(this);
        OrePrefixes.wireGt08.add(this);
        OrePrefixes.wireGt12.add(this);
        OrePrefixes.wireGt16.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
        ItemStack aStack) {
        if (tt == TunnelType.ME) {
            try {
                tt = TunnelType.valueOf("GT_POWER");
            } catch (IllegalArgumentException ignored) {
                tt = TunnelType.IC2_POWER;
            }
        }

        int cableWidth;
        OrePrefixes correspondingCable;

        switch (aPrefix) {
            case wireGt01 -> {
                cableWidth = 1;
                correspondingCable = OrePrefixes.cableGt01;
                if (!aMaterial.contains(SubTag.NO_SMASHING)) {
                    // Bender recipes
                    {
                        if (GT_OreDictUnificator.get(OrePrefixes.springSmall, aMaterial, 1L) != null) {
                            GT_Values.RA.stdBuilder()
                                .itemInputs(GT_Utility.copyAmount(1, aStack), GT_Utility.getIntegratedCircuit(1))
                                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.springSmall, aMaterial, 2L))
                                .duration(5 * SECONDS)
                                .eut(calculateRecipeEU(aMaterial, 8))
                                .addTo(sBenderRecipes);
                        }
                    }

                    // Wiremill Recipes
                    {
                        if (GT_OreDictUnificator.get(OrePrefixes.wireFine, aMaterial, 1L) != null) {
                            GT_Values.RA.stdBuilder()
                                .itemInputs(GT_Utility.copyAmount(1, aStack), GT_Utility.getIntegratedCircuit(1))
                                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireFine, aMaterial, 4L))
                                .duration(10 * SECONDS)
                                .eut(calculateRecipeEU(aMaterial, 8))
                                .addTo(sWiremillRecipes);
                        }
                    }
                }

                // crafting recipe
                if (aMaterial.mUnificatable && (aMaterial.mMaterialInto == aMaterial)
                    && !aMaterial.contains(SubTag.NO_WORKING)
                    && (aMaterial.getProcessingMaterialTierEU() < TierEU.IV)) {
                    GT_ModHandler.addCraftingRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 1L),
                        GT_Proxy.tBits,
                        new Object[] { "Xx", 'X', OrePrefixes.plate.get(aMaterial) });

                }

                // Assembler recipes
                {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_Utility.copyAmount(2, aStack), GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt02, aMaterial, 1L))
                        .duration(7 * SECONDS + 10 * TICKS)
                        .eut(calculateRecipeEU(aMaterial, 8))
                        .addTo(sAssemblerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_Utility.copyAmount(4, aStack), GT_Utility.getIntegratedCircuit(4))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt04, aMaterial, 1L))
                        .duration(10 * SECONDS)
                        .eut(calculateRecipeEU(aMaterial, 8))
                        .addTo(sAssemblerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_Utility.copyAmount(8, aStack), GT_Utility.getIntegratedCircuit(8))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt08, aMaterial, 1L))
                        .duration(15 * SECONDS)
                        .eut(calculateRecipeEU(aMaterial, 8))
                        .addTo(sAssemblerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_Utility.copyAmount(12, aStack), GT_Utility.getIntegratedCircuit(12))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt12, aMaterial, 1L))
                        .duration(20 * SECONDS)
                        .eut(calculateRecipeEU(aMaterial, 8))
                        .addTo(sAssemblerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_Utility.copyAmount(16, aStack), GT_Utility.getIntegratedCircuit(16))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt16, aMaterial, 1L))
                        .duration(25 * SECONDS)
                        .eut(calculateRecipeEU(aMaterial, 8))
                        .addTo(sAssemblerRecipes);
                }
            }
            case wireGt02 -> {
                cableWidth = 2;
                correspondingCable = OrePrefixes.cableGt02;
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {
                    // Shapeless crafting recipes
                    {
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 2L),
                            new Object[] { aOreDictName });

                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial) });
                    }
                }
            }
            case wireGt04 -> {
                cableWidth = 4;
                correspondingCable = OrePrefixes.cableGt04;
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {
                    // Shapeless crafting recipes
                    {
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 4L),
                            new Object[] { aOreDictName });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial),
                                OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial) });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt02.get(aMaterial), OrePrefixes.wireGt02.get(aMaterial) });
                    }
                }
            }
            case wireGt08 -> {
                cableWidth = 8;
                correspondingCable = OrePrefixes.cableGt08;
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {
                    // Shapeless crafting recipes
                    {
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 8L),
                            new Object[] { aOreDictName });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial),
                                OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial),
                                OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial),
                                OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial) });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt04.get(aMaterial), OrePrefixes.wireGt04.get(aMaterial) });
                    }
                }
            }
            case wireGt12 -> {
                cableWidth = 12;
                correspondingCable = OrePrefixes.cableGt12;
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {
                    // Shapeless crafting recipes
                    {
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 12L),
                            new Object[] { aOreDictName });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt08.get(aMaterial), OrePrefixes.wireGt04.get(aMaterial) });
                    }
                }
            }
            case wireGt16 -> {
                cableWidth = 16;
                correspondingCable = OrePrefixes.cableGt16;
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {
                    // Shapeless crafting recipes
                    {
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 16L),
                            new Object[] { aOreDictName });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt08.get(aMaterial), OrePrefixes.wireGt08.get(aMaterial) });
                        GT_ModHandler.addShapelessCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            new Object[] { OrePrefixes.wireGt12.get(aMaterial), OrePrefixes.wireGt04.get(aMaterial) });
                    }

                    AE2addNewAttunement(aStack);
                }
            }
            default -> {
                GT_Log.err.println(
                    "OrePrefix " + aPrefix.name() + " cannot be registered as a cable for Material " + aMaterial.mName);
                return;
            }
        }

        int costMultiplier = cableWidth / 4 + 1;

        switch (aMaterial.mName) {
            case "RedAlloy", "Cobalt", "Lead", "Tin", "Zinc", "SolderingAlloy" -> {
                ArrayList<Object> craftingListRubber = new ArrayList<>();
                craftingListRubber.add(aOreDictName);
                for (int i = 0; i < costMultiplier; i++) {
                    craftingListRubber.add(OrePrefixes.plate.get(Materials.Rubber));
                }

                // shapeless crafting
                if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) != null) {
                    GT_ModHandler.addShapelessCraftingRecipe(
                        GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L),
                        craftingListRubber.toArray());
                }

                // Packer recipe
                if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) != null) {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_Utility.copyAmount(1, aStack),
                            GT_OreDictUnificator.get(OrePrefixes.plate.get(Materials.Rubber), costMultiplier))
                        .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(sBoxinatorRecipes);
                }
                // alloy smelter recipes
                {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.cableGt01, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(sAlloySmelterRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, aMaterial, 1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L))
                        .duration(10 * SECONDS)
                        .eut(16)
                        .addTo(sAlloySmelterRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, aMaterial, 1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.cableGt04, aMaterial, 1L))
                        .duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_LV)
                        .addTo(sAlloySmelterRecipes);
                }
                // Assembler recipes
                {
                    if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) != null) {
                        GT_Values.RA.stdBuilder()
                            .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(Materials.Rubber.getMolten(144L * costMultiplier))
                            .duration(5 * SECONDS)
                            .eut(8)
                            .addTo(sAssemblerRecipes);

                        GT_Values.RA.stdBuilder()
                            .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(Materials.StyreneButadieneRubber.getMolten(108L * costMultiplier))
                            .duration(5 * SECONDS)
                            .eut(8)
                            .addTo(sAssemblerRecipes);

                        GT_Values.RA.stdBuilder()
                            .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(Materials.Silicone.getMolten(72L * costMultiplier))
                            .duration(5 * SECONDS)
                            .eut(8)
                            .addTo(sAssemblerRecipes);

                        for (Materials dielectric : dielectrics) {
                            for (Materials syntheticRubber : syntheticRubbers) {

                                GT_Values.RA.stdBuilder()
                                    .itemInputs(GT_Utility.copyAmount(4, aStack), dielectric.getDust(costMultiplier))
                                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 4L))
                                    .fluidInputs(syntheticRubber.getMolten(costMultiplier * 144L))
                                    .duration(20 * SECONDS)
                                    .eut(8)
                                    .addTo(sAssemblerRecipes);

                                GT_Values.RA.stdBuilder()
                                    .itemInputs(aStack, dielectric.getDustSmall(costMultiplier))
                                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                                    .fluidInputs(syntheticRubber.getMolten(costMultiplier * 36L))
                                    .duration(5 * SECONDS)
                                    .eut(8)
                                    .addTo(sAssemblerRecipes);
                            }
                        }
                    }
                }
            }
            case "Iron", "Nickel", "Cupronickel", "Copper", "AnnealedCopper", "Kanthal", "Gold", "Electrum", "Silver", "Nichrome", "Steel", "BlackSteel", "Titanium", "Aluminium", "BlueAlloy", "NetherStar", "RedstoneAlloy" -> {

                if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) == null) {
                    break;
                }
                // Assembler recipes
                GT_Values.RA.stdBuilder()
                    .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                    .fluidInputs(Materials.Rubber.getMolten(144 * costMultiplier))
                    .duration(5 * SECONDS)
                    .eut(8)
                    .addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(108 * costMultiplier))
                    .duration(5 * SECONDS)
                    .eut(8)
                    .addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(aStack, GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                    .fluidInputs(Materials.Silicone.getMolten(72 * costMultiplier))
                    .duration(5 * SECONDS)
                    .eut(8)
                    .addTo(sAssemblerRecipes);

                for (Materials dielectric : dielectrics) {
                    for (Materials syntheticRubber : syntheticRubbers) {

                        GT_Values.RA.stdBuilder()
                            .itemInputs(GT_Utility.copyAmount(4, aStack), dielectric.getDust(costMultiplier))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 4L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 144L))
                            .duration(20 * SECONDS)
                            .eut(8)
                            .addTo(sAssemblerRecipes);

                        GT_Values.RA.stdBuilder()
                            .itemInputs(aStack, dielectric.getDustSmall(costMultiplier))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 36L))
                            .duration(5 * SECONDS)
                            .eut(8)
                            .addTo(sAssemblerRecipes);
                    }
                }
            }

            default -> {
                if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) == null) {
                    break;
                }

                // Assembler recipes
                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        aStack,
                        GT_OreDictUnificator.get(OrePrefixes.foil, aMaterial, costMultiplier),
                        GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                    .fluidInputs(Materials.Silicone.getMolten(costMultiplier * 72))
                    .duration(5 * SECONDS)
                    .eut(calculateRecipeEU(aMaterial, 8))
                    .addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        aStack,
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, costMultiplier),
                        GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                    .fluidInputs(Materials.Silicone.getMolten(costMultiplier * 72))
                    .duration(5 * SECONDS)
                    .eut(calculateRecipeEU(aMaterial, 8))
                    .addTo(sAssemblerRecipes);

                for (Materials dielectric : dielectrics) {
                    for (Materials syntheticRubber : syntheticRubbers) {

                        GT_Values.RA.stdBuilder()
                            .itemInputs(
                                GT_Utility.copyAmount(4, aStack),
                                dielectric.getDust(costMultiplier),
                                GT_OreDictUnificator.get(OrePrefixes.foil, aMaterial, costMultiplier * 4L))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 4L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 144L))
                            .duration(20 * SECONDS)
                            .eut(calculateRecipeEU(aMaterial, 8))
                            .addTo(sAssemblerRecipes);
                        GT_Values.RA.stdBuilder()
                            .itemInputs(
                                GT_Utility.copyAmount(4, aStack),
                                dielectric.getDust(costMultiplier),
                                GT_OreDictUnificator
                                    .get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, costMultiplier * 4L))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 4L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 144L))
                            .duration(20 * SECONDS)
                            .eut(calculateRecipeEU(aMaterial, 8))
                            .addTo(sAssemblerRecipes);
                        GT_Values.RA.stdBuilder()
                            .itemInputs(
                                aStack,
                                dielectric.getDustSmall(costMultiplier),
                                GT_OreDictUnificator.get(OrePrefixes.foil, aMaterial, costMultiplier))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 36L))
                            .duration(5 * SECONDS)
                            .eut(calculateRecipeEU(aMaterial, 8))
                            .addTo(sAssemblerRecipes);
                        GT_Values.RA.stdBuilder()
                            .itemInputs(
                                aStack,
                                dielectric.getDustSmall(costMultiplier),
                                GT_OreDictUnificator
                                    .get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, costMultiplier))
                            .itemOutputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                            .fluidInputs(syntheticRubber.getMolten(costMultiplier * 36L))
                            .duration(5 * SECONDS)
                            .eut(calculateRecipeEU(aMaterial, 8))
                            .addTo(sAssemblerRecipes);
                    }
                }
            }
        }

        if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) != null) {
            GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L))
                .itemOutputs(GT_Utility.copyAmount(1, aStack))
                .duration(5 * SECONDS)
                .eut(calculateRecipeEU(aMaterial, 8))
                .addTo(sUnboxinatorRecipes);
        }

        if (GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L) != null) {
            AE2AddNetAttunementCable(aStack, correspondingCable, aMaterial);
        }
    }

    // region AE2 compat
    static {
        setAE2Field();
    }

    private static void setAE2Field() {
        tt = TunnelType.ME;
    }

    private void AE2addNewAttunement(ItemStack aStack) {
        Api.INSTANCE.registries()
            .p2pTunnel()
            .addNewAttunement(aStack, (TunnelType) tt);
    }

    private void AE2AddNetAttunementCable(ItemStack aStack, OrePrefixes correspondingCable, Materials aMaterial) {
        Api.INSTANCE.registries()
            .p2pTunnel()
            .addNewAttunement(aStack, (TunnelType) tt);
        Api.INSTANCE.registries()
            .p2pTunnel()
            .addNewAttunement(GT_OreDictUnificator.get(correspondingCable, aMaterial, 1L), (TunnelType) tt);
    }
    // end region
}
