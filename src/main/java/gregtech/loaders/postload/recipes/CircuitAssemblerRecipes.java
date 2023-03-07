package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.GT_Values.MOD_ID_DC;
import static gregtech.api.enums.GT_Values.MOD_ID_RC;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.loaders.postload.GT_MachineRecipeLoader.isRailcraftLoaded;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.*;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.loaders.postload.GT_MachineRecipeLoader;

public class CircuitAssemblerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Copper, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 0),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.AnnealedCopper, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 0),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tin, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 1),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Bronze, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 2),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 3),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 3),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Gold, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 4),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Diamond, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 5),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        getModItem(MOD_ID_DC, "item.LongObsidianRod", 2L, 0) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 6),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Blaze, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 7),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Rubber, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 8),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Emerald, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 9),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Apatite, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 10),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lapis, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 11),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EnderEye, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 12),
                200,
                (int) TierEU.RECIPE_LV);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium, 2L) },
                Materials.Glass.getMolten(576L),
                getModItem(GT_MachineRecipeLoader.aTextForestry, "thermionicTubes", 4L, 13),
                200,
                (int) TierEU.RECIPE_LV);

        if (!isRailcraftLoaded) return;
        for (Materials tMat : Materials.values()) {
            if (tMat.isProperSolderingFluid()) {
                int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                        : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

                // Railcraft Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                ItemList.Cover_Controller.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 4L, 0),
                        300,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                ItemList.Sensor_LV.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 4L, 1),
                        300,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                getModItem(MOD_ID_RC, "part.signal.lamp", 1L, 0) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 4L, 2),
                        300,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Cover_Controller.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 8L, 0),
                        400,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Sensor_LV.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 8L, 1),
                        400,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                getModItem(MOD_ID_RC, "part.signal.lamp", 1L, 0) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 8L, 2),
                        400,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Cover_Controller.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 16L, 0),
                        500,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Sensor_LV.get(1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 16L, 1),
                        500,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                getModItem(MOD_ID_RC, "part.signal.lamp", 1L, 0) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        getModItem(MOD_ID_RC, "part.circuit", 16L, 2),
                        500,
                        (int) TierEU.RECIPE_LV);
            }
        }

        for (Materials tMat : Materials.values()) {
            if (tMat.isProperSolderingFluid()) {
                int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                        : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Iron, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(1152L * tMultiplier / 2L),
                        getModItem("Forestry", "chipsets", 1L, 0),
                        200,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Bronze, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(1152L * tMultiplier / 2L),
                        getModItem("Forestry", "chipsets", 1L, 1),
                        200,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(1152L * tMultiplier / 2L),
                        getModItem("Forestry", "chipsets", 1L, 2),
                        200,
                        (int) TierEU.RECIPE_LV);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Electrum, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(1152L * tMultiplier / 2L),
                        getModItem("Forestry", "chipsets", 1L, 3),
                        200,
                        (int) TierEU.RECIPE_LV);
            }
        }
    }
}
