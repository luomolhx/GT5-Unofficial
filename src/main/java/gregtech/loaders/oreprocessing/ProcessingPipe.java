package gregtech.loaders.oreprocessing;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_Utility.calculateRecipeEU;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ProcessingPipe implements gregtech.api.interfaces.IOreRecipeRegistrator {

    public ProcessingPipe() {
        OrePrefixes.pipeHuge.add(this);
        OrePrefixes.pipeLarge.add(this);
        OrePrefixes.pipeMedium.add(this);
        OrePrefixes.pipeSmall.add(this);
        OrePrefixes.pipeTiny.add(this);
        OrePrefixes.pipeRestrictiveHuge.add(this);
        OrePrefixes.pipeRestrictiveLarge.add(this);
        OrePrefixes.pipeRestrictiveMedium.add(this);
        OrePrefixes.pipeRestrictiveSmall.add(this);
        OrePrefixes.pipeRestrictiveTiny.add(this);
        OrePrefixes.pipeQuadruple.add(this);
        OrePrefixes.pipeNonuple.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
            ItemStack aStack) {
        switch (aPrefix) {
            case pipeHuge:
            case pipeLarge:
            case pipeMedium:
            case pipeSmall:
            case pipeTiny:
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {

                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeTiny, aMaterial, 8L),
                            GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "PPP", "h w", "PPP", 'P', OrePrefixes.plate.get(aMaterial) });
                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeSmall, aMaterial, 6L),
                            GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "PWP", "P P", "PHP", 'P',
                                    aMaterial == Materials.Wood ? OrePrefixes.plank.get(aMaterial)
                                            : OrePrefixes.plate.get(aMaterial),
                                    'H',
                                    aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSoftHammer
                                            : ToolDictNames.craftingToolHardHammer,
                                    'W', aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSaw
                                            : ToolDictNames.craftingToolWrench });
                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, aMaterial, 2L),
                            GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "PPP", "W H", "PPP", 'P',
                                    aMaterial == Materials.Wood ? OrePrefixes.plank.get(aMaterial)
                                            : OrePrefixes.plate.get(aMaterial),
                                    'H',
                                    aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSoftHammer
                                            : ToolDictNames.craftingToolHardHammer,
                                    'W', aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSaw
                                            : ToolDictNames.craftingToolWrench });
                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeLarge, aMaterial, 1L),
                            GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "PHP", "P P", "PWP", 'P',
                                    aMaterial == Materials.Wood ? OrePrefixes.plank.get(aMaterial)
                                            : OrePrefixes.plate.get(aMaterial),
                                    'H',
                                    aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSoftHammer
                                            : ToolDictNames.craftingToolHardHammer,
                                    'W', aMaterial.contains(SubTag.WOOD) ? ToolDictNames.craftingToolSaw
                                            : ToolDictNames.craftingToolWrench });
                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeHuge, aMaterial, 1L),
                            GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "DhD", "D D", "DwD", 'D', OrePrefixes.plateDouble.get(aMaterial) });
                }
                break;
            case pipeRestrictiveHuge:
            case pipeRestrictiveLarge:
            case pipeRestrictiveMedium:
            case pipeRestrictiveSmall:
            case pipeRestrictiveTiny:
                RA.addAssemblerRecipe(
                        GT_OreDictUnificator.get(aOreDictName.replaceFirst("Restrictive", ""), null, 1L, false, true),
                        GT_OreDictUnificator.get(
                                OrePrefixes.ring,
                                Materials.Steel,
                                aPrefix.mSecondaryMaterial.mAmount / OrePrefixes.ring.mMaterialAmount),
                        GT_Utility.copyAmount(1L, aStack),
                        (int) (aPrefix.mSecondaryMaterial.mAmount * 400L / OrePrefixes.ring.mMaterialAmount),
                        4);
                break;
            case pipeQuadruple:
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {

                    GT_ModHandler.addCraftingRecipe(
                            GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, aMaterial, 1),
                            GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "MM ", "MM ", "   ", 'M',
                                    GT_OreDictUnificator.get(OrePrefixes.pipeMedium, aMaterial, 1) });
                }

                RA.addAssemblerRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, aMaterial, 4),
                        GT_Utility.getIntegratedCircuit(9),
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, aMaterial, 1),
                        60,
                        calculateRecipeEU(aMaterial, 4));
                break;
            case pipeNonuple:
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {

                    GT_ModHandler.addCraftingRecipe(
                            GT_Utility.copyAmount(1, aStack),
                            GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED,
                            new Object[] { "PPP", "PPP", "PPP", 'P', GT_OreDictUnificator
                                    .get(aOreDictName.replaceFirst("Nonuple", "Small"), null, 1L, false, true) });
                }

                RA.addAssemblerRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.pipeSmall, aMaterial, 9),
                        GT_Utility.getIntegratedCircuit(9),
                        GT_OreDictUnificator.get(OrePrefixes.pipeNonuple, aMaterial, 1),
                        60,
                        calculateRecipeEU(aMaterial, 8));
                break;
            default:
                break;
        }
    }
}
