package gregtech.api.multitileentity.multiblock.casing;

import java.util.UUID;

import net.minecraft.nbt.NBTTagCompound;

import com.gtnewhorizons.modularui.api.screen.ModularWindow.Builder;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.gtnewhorizons.modularui.common.widget.textfield.TextFieldWidget;

import gregtech.api.enums.GT_Values.NBT;
import gregtech.api.multitileentity.interfaces.IMultiBlockController;

public class InventoryUpgrade extends AdvancedCasing {

    public UUID mInventoryID;
    public static final int INPUT = 0;
    public static final int OUTPUT = 1;
    public static final int BOTH = 2;
    private String mInventoryName = "inventory";
    private int mInventorySize;
    private int mType = BOTH;

    public String getInventoryName() {
        return mInventoryName;
    }

    public void setInventoryName(String aInventoryName) {
        mInventoryName = aInventoryName;
    }

    @Override
    protected void customWork(IMultiBlockController aTarget) {
        int tInvSize = mInventorySize;
        if (mType == BOTH) {
            tInvSize /= 2;
        }
        aTarget.registerInventory(mInventoryName, mInventoryID.toString(), tInvSize, mType);
    }

    @Override
    public String getTileEntityName() {
        return "gt.multitileentity.multiblock.inventory";
    }

    @Override
    public void readMultiTileNBT(NBTTagCompound aNBT) {
        super.readMultiTileNBT(aNBT);
        if (aNBT.hasKey(NBT.UPGRADE_INVENTORY_UUID)) {
            mInventoryID = UUID.fromString(aNBT.getString(NBT.UPGRADE_INVENTORY_UUID));
        } else {
            mInventoryID = UUID.randomUUID();
        }
        mInventorySize = aNBT.getInteger(NBT.UPGRADE_INVENTORY_SIZE);
        mInventoryName = aNBT.getString(NBT.UPGRADE_INVENTORY_NAME);

    }

    @Override
    public void writeMultiTileNBT(NBTTagCompound aNBT) {
        super.writeMultiTileNBT(aNBT);
        aNBT.setString(NBT.UPGRADE_INVENTORY_UUID, mInventoryID.toString());
        aNBT.setString(NBT.UPGRADE_INVENTORY_NAME, mInventoryName);
    }

    @Override
    protected void onBaseTEDestroyed() {
        super.onBaseTEDestroyed();
        unregisterInventories();
    }

    private void unregisterInventories() {
        final IMultiBlockController controller = getTarget(false);
        if (controller != null) {
            controller.unregisterInventory(mInventoryName, mInventoryID.toString(), mType);
        }
    }

    @Override
    public boolean hasGui(byte aSide) {
        return true;
    }

    @Override
    public void addUIWidgets(Builder builder, UIBuildContext buildContext) {
        builder.widget(new TextFieldWidget().setGetter(() -> mInventoryName).setSetter((val) -> {
            mInventoryName = val;
            final IMultiBlockController controller = getTarget(false);
            if (controller != null) {
                controller.changeInventoryName(mInventoryName, mInventoryID.toString(), mType);
            }
        }).setSize(100, 25).setPos(50, 30));
    }
}
