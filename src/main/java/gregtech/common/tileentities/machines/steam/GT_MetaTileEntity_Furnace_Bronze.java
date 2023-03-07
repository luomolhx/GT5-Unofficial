package gregtech.common.tileentities.machines.steam;

import static gregtech.api.enums.Textures.BlockIcons.*;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.SoundResource;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_Bronze;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

public class GT_MetaTileEntity_Furnace_Bronze extends GT_MetaTileEntity_BasicMachine_Bronze {

    public GT_MetaTileEntity_Furnace_Bronze(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional, "Smelting things with compressed Steam", 1, 1, false);
    }

    public GT_MetaTileEntity_Furnace_Bronze(String aName, String aDescription, ITexture[][][] aTextures) {
        super(aName, aDescription, aTextures, 1, 1, false);
    }

    public GT_MetaTileEntity_Furnace_Bronze(String aName, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aDescription, aTextures, 1, 1, false);
    }

    @Override
    protected boolean isBricked() {
        return true;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_Furnace_Bronze(this.mName, this.mDescriptionArray, this.mTextures);
    }

    @Override
    public GT_Recipe.GT_Recipe_Map getRecipeList() {
        return GT_Recipe.GT_Recipe_Map.sFurnaceRecipes;
    }

    @Override
    public int checkRecipe() {
        if (null != (this.mOutputItems[0] = GT_ModHandler.getSmeltingOutput(getInputAt(0), true, getOutputAt(0)))) {
            this.mEUt = 4;
            this.mMaxProgresstime = 256;
            return 2;
        }
        return 0;
    }

    @Override
    protected boolean allowPutStackValidated(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide,
            ItemStack aStack) {
        return super.allowPutStackValidated(aBaseMetaTileEntity, aIndex, aSide, aStack)
                && GT_ModHandler.getSmeltingOutput(GT_Utility.copyAmount(64L, aStack), false, null) != null;
    }

    @Override
    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        if (aIndex == 1) {
            GT_Utility.doSoundAtClient(SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP, 10, 1.0F, aX, aY, aZ);
        }
    }

    @Override
    public void startProcess() {
        sendLoopStart((byte) 1);
    }

    @Override
    public ITexture[] getSideFacingActive(byte aColor) {
        return new ITexture[] { super.getSideFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_SIDE_STEAM_FURNACE_ACTIVE),
                TextureFactory.builder().addIcon(OVERLAY_SIDE_STEAM_FURNACE_ACTIVE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getSideFacingInactive(byte aColor) {
        return new ITexture[] { super.getSideFacingInactive(aColor)[0], TextureFactory.of(OVERLAY_SIDE_STEAM_FURNACE),
                TextureFactory.builder().addIcon(OVERLAY_SIDE_STEAM_FURNACE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getFrontFacingActive(byte aColor) {
        return new ITexture[] { super.getFrontFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_FRONT_STEAM_FURNACE_ACTIVE),
                TextureFactory.builder().addIcon(OVERLAY_FRONT_STEAM_FURNACE_ACTIVE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getFrontFacingInactive(byte aColor) {
        return new ITexture[] { super.getFrontFacingInactive(aColor)[0], TextureFactory.of(OVERLAY_FRONT_STEAM_FURNACE),
                TextureFactory.builder().addIcon(OVERLAY_FRONT_STEAM_FURNACE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getTopFacingActive(byte aColor) {
        return new ITexture[] { super.getTopFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_TOP_STEAM_FURNACE_ACTIVE),
                TextureFactory.builder().addIcon(OVERLAY_BOTTOM_STEAM_FURNACE_ACTIVE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getTopFacingInactive(byte aColor) {
        return new ITexture[] { super.getTopFacingInactive(aColor)[0], TextureFactory.of(OVERLAY_TOP_STEAM_FURNACE),
                TextureFactory.builder().addIcon(OVERLAY_TOP_STEAM_FURNACE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getBottomFacingActive(byte aColor) {
        return new ITexture[] { super.getBottomFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_BOTTOM_STEAM_FURNACE_ACTIVE),
                TextureFactory.builder().addIcon(OVERLAY_BOTTOM_STEAM_FURNACE_ACTIVE_GLOW).glow().build() };
    }

    @Override
    public ITexture[] getBottomFacingInactive(byte aColor) {
        return new ITexture[] { super.getBottomFacingInactive(aColor)[0],
                TextureFactory.of(
                        TextureFactory.of(OVERLAY_BOTTOM_STEAM_FURNACE),
                        TextureFactory.builder().addIcon(OVERLAY_BOTTOM_STEAM_FURNACE_GLOW).glow().build()) };
    }
}
