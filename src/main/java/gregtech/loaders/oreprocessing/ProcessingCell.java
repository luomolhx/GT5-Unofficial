package gregtech.loaders.oreprocessing;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ProcessingCell implements IOreRecipeRegistrator {

    public ProcessingCell() {
        OrePrefixes.cell.add(this);
        OrePrefixes.cellPlasma.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
            ItemStack aStack) {
        switch (aPrefix) {
            case cell:
                if (aMaterial == Materials.Empty) {
                    GT_ModHandler.removeRecipeByOutputDelayed(aStack);
                    if (aModName.equalsIgnoreCase("AtomicScience")) {
                        GT_ModHandler.addExtractionRecipe(ItemList.Cell_Empty.get(1L), aStack);
                    }
                } else {
                    if (aMaterial.mFuelPower > 0) {
                        GT_Values.RA.addFuel(
                                GT_Utility.copyAmount(1L, aStack),
                                GT_Utility.getFluidForFilledItem(aStack, true) == null
                                        ? GT_Utility.getContainerItem(aStack, true)
                                        : null,
                                aMaterial.mFuelPower,
                                aMaterial.mFuelType);
                    }
                    if ((aMaterial.mMaterialList.size() > 0) && ((aMaterial.mExtraData & 0x3) != 0)) {
                        int tAllAmount = 0;
                        for (MaterialStack tMat2 : aMaterial.mMaterialList) {
                            tAllAmount = (int) (tAllAmount + tMat2.mAmount);
                        }
                        long tItemAmount = 0L;
                        long tCapsuleCount = GT_ModHandler.getCapsuleCellContainerCountMultipliedWithStackSize(aStack)
                                * -tAllAmount;
                        long tDensityMultiplier = aMaterial.getDensity() > 3628800L ? aMaterial.getDensity() / 3628800L
                                : 1L;
                        ArrayList<ItemStack> tList = new ArrayList<>();
                        for (MaterialStack tMat : aMaterial.mMaterialList) {
                            if (tMat.mAmount > 0L) {
                                ItemStack tStack;
                                if (tMat.mMaterial == Materials.Air) {
                                    tStack = ItemList.Cell_Air.get(tMat.mAmount * tDensityMultiplier / 2L);
                                } else {
                                    tStack = GT_OreDictUnificator.get(OrePrefixes.dust, tMat.mMaterial, tMat.mAmount);
                                    if (tStack == null) {
                                        tStack = GT_OreDictUnificator
                                                .get(OrePrefixes.cell, tMat.mMaterial, tMat.mAmount);
                                    }
                                }
                                if (tItemAmount + tMat.mAmount * 3628800L
                                        <= aStack.getMaxStackSize() * aMaterial.getDensity()) {
                                    tItemAmount += tMat.mAmount * 3628800L;
                                    if (tStack != null) {
                                        tStack.stackSize = ((int) (tStack.stackSize * tDensityMultiplier));
                                        while ((tStack.stackSize > 64)
                                                && (tCapsuleCount
                                                        + GT_ModHandler.getCapsuleCellContainerCount(tStack) * 64L < 0L
                                                                ? tList.size() < 5
                                                                : tList.size() < 6)
                                                && (tCapsuleCount
                                                        + GT_ModHandler.getCapsuleCellContainerCount(tStack) * 64L
                                                        <= 64L)) {
                                            tCapsuleCount += GT_ModHandler.getCapsuleCellContainerCount(tStack) * 64L;
                                            tList.add(GT_Utility.copyAmount(64L, tStack));
                                            tStack.stackSize -= 64;
                                        }
                                        int tThisCapsuleCount = GT_ModHandler
                                                .getCapsuleCellContainerCountMultipliedWithStackSize(tStack);
                                        if (tStack.stackSize > 0 && tCapsuleCount + tThisCapsuleCount <= 64L) {
                                            if (tCapsuleCount + tThisCapsuleCount < 0L ? tList.size() < 5
                                                    : tList.size() < 6) {
                                                tCapsuleCount += tThisCapsuleCount;
                                                tList.add(tStack);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        tItemAmount = GT_Utility.ceilDiv(tItemAmount * tDensityMultiplier, aMaterial.getDensity());
                        if (tList.size() > 0) {
                            if ((aMaterial.mExtraData & 0x1) != 0) {
                                if (GT_Utility.getFluidForFilledItem(aStack, true) == null) {
                                    // dust stuffed cell e.g. Phosphate, Phosphorous Pentoxide
                                    GT_Values.RA.addElectrolyzerRecipe(
                                            GT_Utility.copyAmount(tItemAmount, aStack),
                                            tCapsuleCount <= 0L ? 0 : (int) tCapsuleCount,
                                            tList.get(0),
                                            tList.size() >= 2 ? tList.get(1) : null,
                                            tList.size() >= 3 ? tList.get(2) : null,
                                            tList.size() >= 4 ? tList.get(3) : null,
                                            tList.size() >= 5 ? tList.get(4) : null,
                                            tCapsuleCount >= 0L ? tList.size() >= 6 ? tList.get(5) : null
                                                    : ItemList.Cell_Empty.get(-tCapsuleCount),
                                            (int) Math.max(1L, Math.abs(aMaterial.getProtons() * 2L * tItemAmount)),
                                            Math.min(4, tList.size()) * 30);
                                } else {
                                    long tCellBalance = tCapsuleCount + tItemAmount - 1;
                                    GT_Values.RA.addElectrolyzerRecipe(
                                            aStack,
                                            tCellBalance <= 0L ? 0 : (int) tCellBalance,
                                            tList.get(0),
                                            tList.size() >= 2 ? tList.get(1) : null,
                                            tList.size() >= 3 ? tList.get(2) : null,
                                            tList.size() >= 4 ? tList.get(3) : null,
                                            tList.size() >= 5 ? tList.get(4) : null,
                                            tCapsuleCount >= 0L ? tList.size() >= 6 ? tList.get(5) : null
                                                    : tCellBalance < 0 ? ItemList.Cell_Empty.get(-tCellBalance) : null,
                                            (int) Math.max(1L, Math.abs(aMaterial.getProtons() * 8L * tItemAmount)),
                                            Math.min(4, tList.size()) * 30);
                                }
                            }
                            if ((aMaterial.mExtraData & 0x2) != 0) {
                                GT_Values.RA.addCentrifugeRecipe(
                                        GT_Utility.copyAmount(tItemAmount, aStack),
                                        tCapsuleCount <= 0L ? 0 : (int) tCapsuleCount,
                                        tList.get(0),
                                        tList.size() >= 2 ? tList.get(1) : null,
                                        tList.size() >= 3 ? tList.get(2) : null,
                                        tList.size() >= 4 ? tList.get(3) : null,
                                        tList.size() >= 5 ? tList.get(4) : null,
                                        tCapsuleCount >= 0L ? tList.size() >= 6 ? tList.get(5) : null
                                                : ItemList.Cell_Empty.get(-tCapsuleCount),
                                        (int) Math.max(1L, Math.abs(aMaterial.getMass() * 2L * tItemAmount)));
                            }
                        }
                    }
                }
                break;
            case cellPlasma:
                if (aMaterial == Materials.Empty) {
                    GT_ModHandler.removeRecipeByOutputDelayed(aStack);
                } else {
                    GT_Values.RA.addFuel(
                            GT_Utility.copyAmount(1L, aStack),
                            GT_Utility.getFluidForFilledItem(aStack, true) == null
                                    ? GT_Utility.getContainerItem(aStack, true)
                                    : null,
                            (int) Math.max(1024L, 1024L * aMaterial.getMass()),
                            4);
                    GT_Values.RA.addVacuumFreezerRecipe(
                            GT_Utility.copyAmount(1L, aStack),
                            gregtech.api.util.GT_OreDictUnificator.get(OrePrefixes.cell, aMaterial, 1L),
                            (int) Math.max(aMaterial.getMass() * 2L, 1L));
                }
                break;
            default:
                break;
        }
    }
}
