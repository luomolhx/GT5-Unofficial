package gregtech.common.covers;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.ICoverable;

public class GT_Cover_RedstoneReceiverExternal extends GT_Cover_RedstoneWirelessBase {

    /**
     * @deprecated use {@link #GT_Cover_RedstoneReceiverExternal(ITexture coverTexture)} instead
     */
    @Deprecated
    public GT_Cover_RedstoneReceiverExternal() {
        this(null);
    }

    public GT_Cover_RedstoneReceiverExternal(ITexture coverTexture) {
        super(coverTexture);
    }

    @Override
    public boolean isRedstoneSensitive(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity,
            long aTimer) {
        return false;
    }

    @Override
    public int doCoverThings(byte aSide, byte aInputRedstone, int aCoverID, int aCoverVariable, ICoverable aTileEntity,
            long aTimer) {
        aTileEntity.setOutputRedstoneSignal(
                aSide,
                GregTech_API.sWirelessRedstone.get(Integer.valueOf(aCoverVariable)) == null ? 0
                        : ((Byte) GregTech_API.sWirelessRedstone.get(Integer.valueOf(aCoverVariable))).byteValue());
        return aCoverVariable;
    }

    @Override
    public boolean manipulatesSidedRedstoneOutput(byte aSide, int aCoverID, int aCoverVariable,
            ICoverable aTileEntity) {
        return true;
    }

    @Override
    public int getTickRate(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return 1;
    }
}
