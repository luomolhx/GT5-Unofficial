package gregtech.common.covers.redstone;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.ICoverable;

public class GT_Cover_AdvancedRedstoneTransmitterInternal
        extends GT_Cover_AdvancedRedstoneTransmitterBase<GT_Cover_AdvancedRedstoneTransmitterBase.TransmitterData> {

    public GT_Cover_AdvancedRedstoneTransmitterInternal(ITexture coverTexture) {
        super(TransmitterData.class, coverTexture);
    }

    @Override
    public TransmitterData createDataObject() {
        return new TransmitterData();
    }

    @Override
    public TransmitterData createDataObject(int aLegacyData) {
        return createDataObject();
    }

    @Override
    public TransmitterData doCoverThingsImpl(byte aSide, byte aInputRedstone, int aCoverID,
            TransmitterData aCoverVariable, ICoverable aTileEntity, long aTimer) {
        byte outputRedstone = aTileEntity.getOutputRedstoneSignal(aSide);
        if (aCoverVariable.isInvert()) {
            if (outputRedstone > 0) outputRedstone = 0;
            else outputRedstone = 15;
        }

        long hash = hashCoverCoords(aTileEntity, aSide);
        setSignalAt(aCoverVariable.getUuid(), aCoverVariable.getFrequency(), hash, outputRedstone);
        return aCoverVariable;
    }

    @Override
    public boolean letsRedstoneGoOutImpl(byte aSide, int aCoverID, TransmitterData aCoverVariable,
            ICoverable aTileEntity) {
        return true;
    }

    @Override
    protected boolean manipulatesSidedRedstoneOutputImpl(byte aSide, int aCoverID, TransmitterData aCoverVariable,
            ICoverable aTileEntity) {
        return true;
    }
}
