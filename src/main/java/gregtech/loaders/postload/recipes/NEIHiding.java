package gregtech.loaders.postload.recipes;

import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import gregtech.common.items.GT_MetaGenerated_Item_03;
import gregtech.loaders.postload.GT_MachineRecipeLoader;

public class NEIHiding implements Runnable {

    @Override
    public void run() {
        for (int g = 0; g < 16; g++) {
            if (!GT_MachineRecipeLoader.isNEILoaded) {
                break;
            }
            API.hideItem(new ItemStack(GT_MetaGenerated_Item_03.INSTANCE, 1, g));
        }
    }
}
