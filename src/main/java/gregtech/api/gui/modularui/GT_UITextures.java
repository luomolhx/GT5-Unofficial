package gregtech.api.gui.modularui;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.gtnewhorizons.modularui.api.drawable.AdaptableUITexture;
import com.gtnewhorizons.modularui.api.drawable.UITexture;

public class GT_UITextures {

    private static final String MODID = "gregtech";

    public static final UITexture TRANSPARENT = UITexture.fullImage(MODID, "gui/picture/transparent");

    public static final AdaptableUITexture BACKGROUND_SINGLEBLOCK_DEFAULT = AdaptableUITexture
            .of(MODID, "gui/background/singleblock_default", 176, 166, 4);
    public static final SteamTexture BACKGROUND_STEAM = SteamTexture
            .adaptableTexture(MODID, "gui/background/%s", 176, 166, 4);
    public static final UITexture BACKGROUND_FUSION_COMPUTER = UITexture
            .fullImage(MODID, "gui/background/fusion_computer");
    public static final AdaptableUITexture BACKGROUND_TEXT_FIELD = AdaptableUITexture
            .of(MODID, "gui/background/text_field", 142, 28, 1);
    public static final AdaptableUITexture BACKGROUND_TEXT_FIELD_LIGHT_GRAY = AdaptableUITexture
            .of(MODID, "gui/background/text_field_light_gray", 61, 12, 1);

    public static final SteamTexture SLOT_ITEM_STEAM = SteamTexture.fullImage(MODID, "gui/slot/item_%s");
    public static final AdaptableUITexture SLOT_DARK_GRAY = AdaptableUITexture
            .of(MODID, "gui/slot/dark_gray", 18, 18, 1);
    public static final AdaptableUITexture SLOT_MAINTENANCE = AdaptableUITexture
            .of(MODID, "gui/slot/maintenance", 20, 20, 1);
    public static final AdaptableUITexture SLOT_UPLIFTED = AdaptableUITexture.of(MODID, "gui/slot/uplifted", 18, 18, 1);

    public static final UITexture OVERLAY_SLOT_ARROW_ME = UITexture.fullImage(MODID, "gui/overlay_slot/arrow_me");
    public static final UITexture OVERLAY_SLOT_BEAKER_1 = UITexture.fullImage(MODID, "gui/overlay_slot/beaker_1");
    public static final UITexture OVERLAY_SLOT_BEAKER_2 = UITexture.fullImage(MODID, "gui/overlay_slot/beaker_2");
    public static final UITexture OVERLAY_SLOT_BEE_DRONE = UITexture.fullImage(MODID, "gui/overlay_slot/bee_drone");
    public static final UITexture OVERLAY_SLOT_BEE_QUEEN = UITexture.fullImage(MODID, "gui/overlay_slot/bee_queen");
    public static final UITexture OVERLAY_SLOT_BENDER = UITexture.fullImage(MODID, "gui/overlay_slot/bender");
    public static final UITexture OVERLAY_SLOT_BOX = UITexture.fullImage(MODID, "gui/overlay_slot/box");
    public static final UITexture OVERLAY_SLOT_BOXED = UITexture.fullImage(MODID, "gui/overlay_slot/boxed");
    public static final UITexture OVERLAY_SLOT_CANISTER = UITexture.fullImage(MODID, "gui/overlay_slot/canister");
    public static final SteamTexture OVERLAY_SLOT_CANISTER_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/canister_%s");
    public static final UITexture OVERLAY_SLOT_CANNER = UITexture.fullImage(MODID, "gui/overlay_slot/canner");
    public static final UITexture OVERLAY_SLOT_CAULDRON = UITexture.fullImage(MODID, "gui/overlay_slot/cauldron");
    public static final UITexture OVERLAY_SLOT_CENTRIFUGE = UITexture.fullImage(MODID, "gui/overlay_slot/centrifuge");
    public static final UITexture OVERLAY_SLOT_CENTRIFUGE_FLUID = UITexture
            .fullImage(MODID, "gui/overlay_slot/centrifuge_fluid");
    public static final SteamTexture OVERLAY_SLOT_CENTRIFUGE_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/centrifuge_%s");
    public static final UITexture OVERLAY_SLOT_CHARGER = UITexture.fullImage(MODID, "gui/overlay_slot/charger");
    public static final UITexture OVERLAY_SLOT_CHARGER_FLUID = UITexture
            .fullImage(MODID, "gui/overlay_slot/charger_fluid");
    public static final UITexture OVERLAY_SLOT_CIRCUIT = UITexture.fullImage(MODID, "gui/overlay_slot/circuit");
    public static final SteamTexture OVERLAY_SLOT_COAL_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/coal_%s");
    public static final UITexture OVERLAY_SLOT_COMPRESSOR = UITexture.fullImage(MODID, "gui/overlay_slot/compressor");
    public static final SteamTexture OVERLAY_SLOT_COMPRESSOR_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/compressor_%s");
    public static final UITexture OVERLAY_SLOT_CRUSHED_ORE = UITexture.fullImage(MODID, "gui/overlay_slot/crushed_ore");
    public static final SteamTexture OVERLAY_SLOT_CRUSHED_ORE_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/crushed_ore_%s");
    public static final UITexture OVERLAY_SLOT_CUTTER_SLICED = UITexture
            .fullImage(MODID, "gui/overlay_slot/cutter_sliced");
    public static final UITexture OVERLAY_SLOT_DATA_ORB = UITexture.fullImage(MODID, "gui/overlay_slot/data_orb");
    public static final UITexture OVERLAY_SLOT_DATA_STICK = UITexture.fullImage(MODID, "gui/overlay_slot/data_stick");
    public static final UITexture OVERLAY_SLOT_DUST = UITexture.fullImage(MODID, "gui/overlay_slot/dust");
    public static final SteamTexture OVERLAY_SLOT_DUST_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/dust_%s");
    public static final UITexture OVERLAY_SLOT_EXPLOSIVE = UITexture.fullImage(MODID, "gui/overlay_slot/explosive");
    public static final UITexture OVERLAY_SLOT_EXTRUDER_SHAPE = UITexture
            .fullImage(MODID, "gui/overlay_slot/extruder_shape");
    public static final UITexture OVERLAY_SLOT_FURNACE = UITexture.fullImage(MODID, "gui/overlay_slot/furnace");
    public static final SteamTexture OVERLAY_SLOT_FURNACE_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/furnace_%s");
    public static final UITexture OVERLAY_SLOT_GEM = UITexture.fullImage(MODID, "gui/overlay_slot/gem");
    public static final UITexture OVERLAY_SLOT_HAMMER = UITexture.fullImage(MODID, "gui/overlay_slot/hammer");
    public static final SteamTexture OVERLAY_SLOT_HAMMER_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/hammer_%s");
    public static final UITexture OVERLAY_SLOT_HEATER_1 = UITexture.fullImage(MODID, "gui/overlay_slot/heater_1");
    public static final UITexture OVERLAY_SLOT_HEATER_2 = UITexture.fullImage(MODID, "gui/overlay_slot/heater_2");
    public static final UITexture OVERLAY_SLOT_IMPLOSION = UITexture.fullImage(MODID, "gui/overlay_slot/implosion");
    public static final UITexture OVERLAY_SLOT_IN = UITexture.fullImage(MODID, "gui/overlay_slot/in");
    public static final SteamTexture OVERLAY_SLOT_IN_STEAM = SteamTexture.fullImage(MODID, "gui/overlay_slot/in_%s");
    public static final SteamTexture OVERLAY_SLOT_INGOT_STEAM = SteamTexture
            .fullImage(MODID, "gui/overlay_slot/ingot_%s");
    public static final UITexture OVERLAY_SLOT_INT_CIRCUIT = UITexture.fullImage(MODID, "gui/overlay_slot/int_circuit");
    public static final UITexture OVERLAY_SLOT_LENS = UITexture.fullImage(MODID, "gui/overlay_slot/lens");
    public static final UITexture OVERLAY_SLOT_MICROSCOPE = UITexture.fullImage(MODID, "gui/overlay_slot/microscope");
    public static final UITexture OVERLAY_SLOT_MOLD = UITexture.fullImage(MODID, "gui/overlay_slot/mold");
    public static final UITexture OVERLAY_SLOT_MOLECULAR_1 = UITexture.fullImage(MODID, "gui/overlay_slot/molecular_1");
    public static final UITexture OVERLAY_SLOT_MOLECULAR_2 = UITexture.fullImage(MODID, "gui/overlay_slot/molecular_2");
    public static final UITexture OVERLAY_SLOT_MOLECULAR_3 = UITexture.fullImage(MODID, "gui/overlay_slot/molecular_3");
    public static final UITexture OVERLAY_SLOT_OUT = UITexture.fullImage(MODID, "gui/overlay_slot/out");
    public static final SteamTexture OVERLAY_SLOT_OUT_STEAM = SteamTexture.fullImage(MODID, "gui/overlay_slot/out_%s");
    public static final UITexture OVERLAY_SLOT_PAGE_BLANK = UITexture.fullImage(MODID, "gui/overlay_slot/page_blank");
    public static final UITexture OVERLAY_SLOT_PAGE_PRINTED = UITexture
            .fullImage(MODID, "gui/overlay_slot/page_printed");
    public static final UITexture OVERLAY_SLOT_PRESS_1 = UITexture.fullImage(MODID, "gui/overlay_slot/press_1");
    public static final UITexture OVERLAY_SLOT_PRESS_2 = UITexture.fullImage(MODID, "gui/overlay_slot/press_2");
    public static final UITexture OVERLAY_SLOT_PRESS_3 = UITexture.fullImage(MODID, "gui/overlay_slot/press_3");
    public static final UITexture OVERLAY_SLOT_RECYCLE = UITexture.fullImage(MODID, "gui/overlay_slot/recycle");
    public static final UITexture OVERLAY_SLOT_ROD_1 = UITexture.fullImage(MODID, "gui/overlay_slot/rod_1");
    public static final UITexture OVERLAY_SLOT_ROD_2 = UITexture.fullImage(MODID, "gui/overlay_slot/rod_2");
    public static final UITexture OVERLAY_SLOT_SLICE_SHAPE = UITexture.fullImage(MODID, "gui/overlay_slot/slice_shape");
    public static final UITexture OVERLAY_SLOT_SLICER_SLICED = UITexture
            .fullImage(MODID, "gui/overlay_slot/slicer_sliced");
    public static final UITexture OVERLAY_SLOT_SQUARE = UITexture.fullImage(MODID, "gui/overlay_slot/square");
    public static final UITexture OVERLAY_SLOT_UUA = UITexture.fullImage(MODID, "gui/overlay_slot/uua");
    public static final UITexture OVERLAY_SLOT_UUM = UITexture.fullImage(MODID, "gui/overlay_slot/uum");
    public static final UITexture OVERLAY_SLOT_VIAL_1 = UITexture.fullImage(MODID, "gui/overlay_slot/vial_1");
    public static final UITexture OVERLAY_SLOT_VIAL_2 = UITexture.fullImage(MODID, "gui/overlay_slot/vial_2");
    public static final UITexture OVERLAY_SLOT_WIREMILL = UITexture.fullImage(MODID, "gui/overlay_slot/wiremill");
    public static final UITexture OVERLAY_SLOT_WRENCH = UITexture.fullImage(MODID, "gui/overlay_slot/wrench");
    public static final UITexture[] OVERLAY_SLOTS_NUMBER = IntStream.range(0, 12)
            .mapToObj(i -> UITexture.fullImage(MODID, "gui/overlay_slot/number_" + i)).collect(Collectors.toList())
            .toArray(new UITexture[0]);

    public static final UITexture PROGRESSBAR_ARROW = UITexture.fullImage(MODID, "gui/progressbar/arrow");
    public static final SteamTexture PROGRESSBAR_ARROW_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/arrow_%s");
    public static final SteamTexture PROGRESSBAR_ARROW_2_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/arrow_2_%s");
    public static final UITexture PROGRESSBAR_ARROW_MULTIPLE = UITexture
            .fullImage(MODID, "gui/progressbar/arrow_multiple");
    public static final UITexture PROGRESSBAR_ASSEMBLE = UITexture.fullImage(MODID, "gui/progressbar/assemble");
    public static final UITexture PROGRESSBAR_ASSEMBLY_LINE_1 = UITexture
            .fullImage(MODID, "gui/progressbar/assemblyline_1");
    public static final UITexture PROGRESSBAR_ASSEMBLY_LINE_2 = UITexture
            .fullImage(MODID, "gui/progressbar/assemblyline_2");
    public static final UITexture PROGRESSBAR_ASSEMBLY_LINE_3 = UITexture
            .fullImage(MODID, "gui/progressbar/assemblyline_3");
    public static final UITexture PROGRESSBAR_BATH = UITexture.fullImage(MODID, "gui/progressbar/bath");
    public static final UITexture PROGRESSBAR_BENDING = UITexture.fullImage(MODID, "gui/progressbar/bending");
    public static final SteamTexture PROGRESSBAR_BOILER_EMPTY_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/boiler_empty_%s");
    public static final UITexture PROGRESSBAR_BOILER_HEAT = UITexture.fullImage(MODID, "gui/progressbar/boiler_heat");
    public static final UITexture PROGRESSBAR_BOILER_STEAM = UITexture.fullImage(MODID, "gui/progressbar/boiler_steam");
    public static final UITexture PROGRESSBAR_BOILER_WATER = UITexture.fullImage(MODID, "gui/progressbar/boiler_water");
    public static final UITexture PROGRESSBAR_CANNER = UITexture.fullImage(MODID, "gui/progressbar/canner");
    public static final UITexture PROGRESSBAR_CIRCUIT_ASSEMBLER = UITexture
            .fullImage(MODID, "gui/progressbar/circuit_assembler");
    public static final UITexture PROGRESSBAR_COMPRESS = UITexture.fullImage(MODID, "gui/progressbar/compress");
    public static final SteamTexture PROGRESSBAR_COMPRESS_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/compress_%s");
    public static final UITexture PROGRESSBAR_CUT = UITexture.fullImage(MODID, "gui/progressbar/cut");
    public static final UITexture PROGRESSBAR_EXTRACT = UITexture.fullImage(MODID, "gui/progressbar/extract");
    public static final SteamTexture PROGRESSBAR_EXTRACT_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/extract_%s");
    public static final UITexture PROGRESSBAR_EXTRUDE = UITexture.fullImage(MODID, "gui/progressbar/extrude");
    public static final SteamTexture PROGRESSBAR_FUEL_STEAM = SteamTexture.fullImage(MODID, "gui/progressbar/fuel_%s");
    public static final UITexture PROGRESSBAR_HAMMER = UITexture.fullImage(MODID, "gui/progressbar/hammer");
    public static final UITexture PROGRESSBAR_HAMMER_BASE = UITexture.fullImage(MODID, "gui/progressbar/hammer_base");
    public static final SteamTexture PROGRESSBAR_HAMMER_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/hammer_%s");
    public static final SteamTexture PROGRESSBAR_HAMMER_BASE_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/hammer_base_%s");
    public static final UITexture PROGRESSBAR_LATHE = UITexture.fullImage(MODID, "gui/progressbar/lathe");
    public static final UITexture PROGRESSBAR_LATHE_BASE = UITexture.fullImage(MODID, "gui/progressbar/lathe_base");
    public static final UITexture PROGRESSBAR_MACERATE = UITexture.fullImage(MODID, "gui/progressbar/macerate");
    public static final SteamTexture PROGRESSBAR_MACERATE_STEAM = SteamTexture
            .fullImage(MODID, "gui/progressbar/macerate_%s");
    public static final UITexture PROGRESSBAR_MAGNET = UITexture.fullImage(MODID, "gui/progressbar/magnet");
    public static final UITexture PROGRESSBAR_MIXER = UITexture.fullImage(MODID, "gui/progressbar/mixer");
    public static final UITexture PROGRESSBAR_RECYCLE = UITexture.fullImage(MODID, "gui/progressbar/recycle");
    public static final UITexture PROGRESSBAR_SIFT = UITexture.fullImage(MODID, "gui/progressbar/sift");
    public static final UITexture PROGRESSBAR_SLICE = UITexture.fullImage(MODID, "gui/progressbar/slice");
    public static final UITexture PROGRESSBAR_STORED_EU = UITexture.fullImage(MODID, "gui/progressbar/stored_eu");
    public static final UITexture PROGRESSBAR_WIREMILL = UITexture.fullImage(MODID, "gui/progressbar/wiremill");

    public static final UITexture TAB_COVER_NORMAL = UITexture.fullImage(MODID, "gui/tab/cover_normal");
    public static final UITexture TAB_COVER_HIGHLIGHT = UITexture.fullImage(MODID, "gui/tab/cover_highlight");
    public static final UITexture TAB_COVER_DISABLED = UITexture.fullImage(MODID, "gui/tab/cover_disabled");
    public static final SteamTexture TAB_COVER_STEAM_NORMAL = SteamTexture.fullImage(MODID, "gui/tab/cover_%s_normal");
    public static final SteamTexture TAB_COVER_STEAM_HIGHLIGHT = SteamTexture
            .fullImage(MODID, "gui/tab/cover_%s_highlight");
    public static final SteamTexture TAB_COVER_STEAM_DISABLED = SteamTexture
            .fullImage(MODID, "gui/tab/cover_%s_disabled");
    public static final AdaptableUITexture TAB_TITLE = AdaptableUITexture.of(MODID, "gui/tab/title", 28, 28, 4);
    public static final AdaptableUITexture TAB_TITLE_DARK = AdaptableUITexture
            .of(MODID, "gui/tab/title_dark", 28, 28, 4);
    public static final SteamTexture TAB_TITLE_STEAM = SteamTexture
            .adaptableTexture(MODID, "gui/tab/title_%s", 28, 28, 4);
    public static final SteamTexture TAB_TITLE_DARK_STEAM = SteamTexture
            .adaptableTexture(MODID, "gui/tab/title_dark_%s", 28, 28, 4);
    public static final AdaptableUITexture TAB_TITLE_ANGULAR = AdaptableUITexture
            .of(MODID, "gui/tab/title_angular", 28, 28, 4);
    public static final SteamTexture TAB_TITLE_ANGULAR_STEAM = SteamTexture
            .adaptableTexture(MODID, "gui/tab/title_angular_%s", 28, 28, 4);

    public static final UITexture BUTTON_STANDARD = AdaptableUITexture.of(MODID, "gui/button/standard", 18, 18, 1);
    public static final UITexture BUTTON_STANDARD_DISABLED = AdaptableUITexture
            .of(MODID, "gui/button/standard_disabled", 18, 18, 1);
    public static final UITexture BUTTON_STANDARD_TOGGLE = AdaptableUITexture
            .of(MODID, "gui/button/standard_toggle", 18, 18, 1);
    public static final UITexture BUTTON_STANDARD_TOGGLE_DISABLED = AdaptableUITexture
            .of(MODID, "gui/button/standard_toggle_disabled", 18, 18, 1);
    public static final UITexture BUTTON_COVER_NORMAL = UITexture.fullImage(MODID, "gui/button/cover_normal");
    public static final UITexture BUTTON_COVER_NORMAL_HOVERED = UITexture
            .fullImage(MODID, "gui/button/cover_normal_hovered");
    public static final UITexture BUTTON_COVER_NORMAL_DISABLED = UITexture
            .fullImage(MODID, "gui/button/cover_normal_disabled");

    public static final UITexture OVERLAY_BUTTON_DISABLE = UITexture.fullImage(MODID, "gui/overlay_button/disable");
    public static final UITexture OVERLAY_BUTTON_REDSTONE_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/redstone_off");
    public static final UITexture OVERLAY_BUTTON_REDSTONE_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/redstone_on");
    public static final UITexture OVERLAY_BUTTON_POWER_SWITCH_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/power_switch_on");
    public static final UITexture OVERLAY_BUTTON_POWER_SWITCH_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/power_switch_off");
    public static final UITexture OVERLAY_BUTTON_VOID_EXCESS_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/void_excess_on");
    public static final UITexture OVERLAY_BUTTON_VOID_EXCESS_ON_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/void_excess_on_disabled");
    public static final UITexture OVERLAY_BUTTON_VOID_EXCESS_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/void_excess_off");
    public static final UITexture OVERLAY_BUTTON_VOID_EXCESS_OFF_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/void_excess_off_disabled");
    public static final UITexture OVERLAY_BUTTON_INPUT_SEPARATION_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/input_separation_on");
    public static final UITexture OVERLAY_BUTTON_INPUT_SEPARATION_ON_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/input_separation_on_disabled");
    public static final UITexture OVERLAY_BUTTON_INPUT_SEPARATION_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/input_separation_off");
    public static final UITexture OVERLAY_BUTTON_INPUT_SEPARATION_OFF_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/input_separation_off_disabled");
    public static final UITexture OVERLAY_BUTTON_RECIPE_LOCKED = UITexture
            .fullImage(MODID, "gui/overlay_button/recipe_locked");
    public static final UITexture OVERLAY_BUTTON_RECIPE_LOCKED_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/recipe_locked_disabled");
    public static final UITexture OVERLAY_BUTTON_RECIPE_UNLOCKED = UITexture
            .fullImage(MODID, "gui/overlay_button/recipe_unlocked");
    public static final UITexture OVERLAY_BUTTON_RECIPE_UNLOCKED_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/recipe_unlocked_disabled");
    public static final UITexture OVERLAY_BUTTON_BATCH_MODE_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/batch_mode_on");
    public static final UITexture OVERLAY_BUTTON_BATCH_MODE_ON_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/batch_mode_on_disabled");
    public static final UITexture OVERLAY_BUTTON_BATCH_MODE_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/batch_mode_off");
    public static final UITexture OVERLAY_BUTTON_BATCH_MODE_OFF_DISABLED = UITexture
            .fullImage(MODID, "gui/overlay_button/batch_mode_off_disabled");
    public static final UITexture OVERLAY_BUTTON_DOWN_TIERING_ON = UITexture
            .fullImage(MODID, "gui/overlay_button/down_tiering_on");
    public static final UITexture OVERLAY_BUTTON_DOWN_TIERING_OFF = UITexture
            .fullImage(MODID, "gui/overlay_button/down_tiering_off");
    public static final UITexture OVERLAY_BUTTON_CHECKMARK = UITexture.fullImage(MODID, "gui/overlay_button/checkmark");
    public static final UITexture OVERLAY_BUTTON_CROSS = UITexture.fullImage(MODID, "gui/overlay_button/cross");
    public static final UITexture OVERLAY_BUTTON_WHITELIST = UITexture.fullImage(MODID, "gui/overlay_button/whitelist");
    public static final UITexture OVERLAY_BUTTON_BLACKLIST = UITexture.fullImage(MODID, "gui/overlay_button/blacklist");
    public static final UITexture OVERLAY_BUTTON_PROGRESS = UITexture.fullImage(MODID, "gui/overlay_button/progress");
    public static final UITexture OVERLAY_BUTTON_EXPORT = UITexture.fullImage(MODID, "gui/overlay_button/export");
    public static final UITexture OVERLAY_BUTTON_IMPORT = UITexture.fullImage(MODID, "gui/overlay_button/import");
    public static final UITexture OVERLAY_BUTTON_AUTOOUTPUT_ITEM = UITexture
            .fullImage(MODID, "gui/overlay_button/autooutput_item");
    public static final UITexture OVERLAY_BUTTON_AUTOOUTPUT_FLUID = UITexture
            .fullImage(MODID, "gui/overlay_button/autooutput_fluid");
    public static final UITexture OVERLAY_BUTTON_ALLOW_INPUT = UITexture
            .fullImage(MODID, "gui/overlay_button/allow_input");
    public static final UITexture OVERLAY_BUTTON_BLOCK_INPUT = UITexture
            .fullImage(MODID, "gui/overlay_button/block_input");
    public static final UITexture OVERLAY_BUTTON_ARROW_GREEN_UP = UITexture
            .fullImage(MODID, "gui/overlay_button/arrow_green_up");
    public static final UITexture OVERLAY_BUTTON_ARROW_GREEN_DOWN = UITexture
            .fullImage(MODID, "gui/overlay_button/arrow_green_down");
    public static final UITexture OVERLAY_BUTTON_CYCLIC = UITexture.fullImage(MODID, "gui/overlay_button/cyclic");
    public static final UITexture OVERLAY_BUTTON_EMIT_ENERGY = UITexture
            .fullImage(MODID, "gui/overlay_button/emit_energy");
    public static final UITexture OVERLAY_BUTTON_EMIT_REDSTONE = UITexture
            .fullImage(MODID, "gui/overlay_button/emit_redstone");
    public static final UITexture OVERLAY_BUTTON_INVERT_REDSTONE = UITexture
            .fullImage(MODID, "gui/overlay_button/invert_redstone");
    public static final UITexture OVERLAY_BUTTON_STOCKING_MODE = UITexture
            .fullImage(MODID, "gui/overlay_button/stocking_mode");
    public static final UITexture OVERLAY_BUTTON_INVERT_FILTER = UITexture
            .fullImage(MODID, "gui/overlay_button/invert_filter");
    public static final UITexture OVERLAY_BUTTON_NBT = UITexture.fullImage(MODID, "gui/overlay_button/nbt");
    public static final UITexture OVERLAY_BUTTON_PRINT = UITexture.fullImage(MODID, "gui/overlay_button/print");
    public static final UITexture OVERLAY_BUTTON_TRANSPOSE = UITexture.fullImage(MODID, "gui/overlay_button/transpose");
    public static final UITexture OVERLAY_BUTTON_BOUNDING_BOX = UITexture
            .fullImage(MODID, "gui/overlay_button/bounding_box");
    public static final UITexture OVERLAY_BUTTON_MINUS_SMALL = UITexture
            .fullImage(MODID, "gui/overlay_button/minus_small");
    public static final UITexture OVERLAY_BUTTON_MINUS_LARGE = UITexture
            .fullImage(MODID, "gui/overlay_button/minus_large");
    public static final UITexture OVERLAY_BUTTON_PLUS_SMALL = UITexture
            .fullImage(MODID, "gui/overlay_button/plus_small");
    public static final UITexture OVERLAY_BUTTON_PLUS_LARGE = UITexture
            .fullImage(MODID, "gui/overlay_button/plus_large");
    public static final UITexture OVERLAY_BUTTON_GATE_AND = UITexture.fullImage(MODID, "gui/overlay_button/gate_and");
    public static final UITexture OVERLAY_BUTTON_GATE_NAND = UITexture.fullImage(MODID, "gui/overlay_button/gate_nand");
    public static final UITexture OVERLAY_BUTTON_GATE_OR = UITexture.fullImage(MODID, "gui/overlay_button/gate_or");
    public static final UITexture OVERLAY_BUTTON_GATE_NOR = UITexture.fullImage(MODID, "gui/overlay_button/gate_nor");
    public static final UITexture OVERLAY_BUTTON_ANALOG = UITexture.fullImage(MODID, "gui/overlay_button/analog");
    public static final UITexture OVERLAY_BUTTON_LOCK = UITexture.fullImage(MODID, "gui/overlay_button/lock");
    public static final UITexture OVERLAY_BUTTON_INPUT_FROM_OUTPUT_SIDE = UITexture
            .fullImage(MODID, "gui/overlay_button/input_from_output_side");
    public static final UITexture OVERLAY_BUTTON_VOID_EXCESS = UITexture
            .fullImage(MODID, "gui/overlay_button/void_excess");
    public static final UITexture OVERLAY_BUTTON_VOID_ALL = UITexture.fullImage(MODID, "gui/overlay_button/void_all");
    public static final UITexture OVERLAY_BUTTON_NEI = UITexture.fullImage(MODID, "gui/overlay_button/nei");

    /**
     * Can adjust size as needed.
     */
    public static final AdaptableUITexture PICTURE_SCREEN_BLACK = AdaptableUITexture
            .of(MODID, "gui/picture/screen_black", 16, 16, 2);

    public static final UITexture PICTURE_RADIATION_WARNING = UITexture
            .fullImage(MODID, "gui/picture/radiation_warning");
    public static final UITexture PICTURE_GT_LOGO_17x17_TRANSPARENT = UITexture
            .fullImage(MODID, "gui/picture/gt_logo_17x17_transparent");
    public static final UITexture PICTURE_GT_LOGO_17x17_TRANSPARENT_GRAY = UITexture
            .fullImage(MODID, "gui/picture/gt_logo_17x17_transparent_gray");
    public static final SteamTexture PICTURE_GT_LOGO_17x17_TRANSPARENT_STEAM = SteamTexture
            .fullImage(MODID, "gui/picture/gt_logo_17x17_transparent_%s");
    public static final UITexture PICTURE_GT_LOGO_18x18 = UITexture.fullImage(MODID, "gui/picture/gt_logo_18x18");
    public static final UITexture PICTURE_GT_LOGO_19x19 = UITexture.fullImage(MODID, "gui/picture/gt_logo_19x19");
    public static final UITexture PICTURE_INFORMATION = UITexture.fullImage(MODID, "gui/picture/information");
    public static final UITexture PICTURE_STALLED_ELECTRICITY = UITexture
            .fullImage(MODID, "gui/picture/stalled_electricity");
    public static final UITexture PICTURE_STALLED_STEAM = UITexture.fullImage(MODID, "gui/picture/stalled_steam");
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_22_RED = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_22_red",
                    87,
                    22,
                    fromRight ? 87 - width : 0,
                    0,
                    fromRight ? 87 : width,
                    22);
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_22_BLUE = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_22_blue",
                    87,
                    22,
                    fromRight ? 87 - width : 0,
                    0,
                    fromRight ? 87 : width,
                    22);
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_22_WHITE = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_22_white",
                    87,
                    22,
                    fromRight ? 87 - width : 0,
                    0,
                    fromRight ? 87 : width,
                    22);
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_24_RED = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_24_red",
                    69,
                    24,
                    fromRight ? 69 - width : 0,
                    0,
                    fromRight ? 69 : width,
                    24);
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_24_BLUE = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_24_blue",
                    69,
                    24,
                    fromRight ? 69 - width : 0,
                    0,
                    fromRight ? 69 : width,
                    24);
    public static final BiFunction<Integer, Boolean, UITexture> PICTURE_ARROW_24_WHITE = (width, fromRight) -> UITexture
            .partly(
                    MODID,
                    "gui/picture/arrow_24_white",
                    69,
                    24,
                    fromRight ? 69 - width : 0,
                    0,
                    fromRight ? 69 : width,
                    24);
    public static final UITexture PICTURE_FLUID_WINDOW = UITexture.fullImage(MODID, "gui/picture/fluid_window");
    public static final UITexture PICTURE_FLUID_TANK = UITexture.fullImage(MODID, "gui/picture/fluid_tank");
    public static final UITexture PICTURE_SLOTS_HOLO_3BY3 = UITexture.fullImage(MODID, "gui/picture/slots_holo_3by3");
    public static final UITexture PICTURE_ARROW_DOUBLE = UITexture.fullImage(MODID, "gui/picture/arrow_double");
    public static final UITexture PICTURE_SUPER_BUFFER = UITexture.fullImage(MODID, "gui/picture/super_buffer");
    public static final UITexture PICTURE_SQUARE_LIGHT_GRAY = UITexture
            .fullImage(MODID, "gui/picture/square_light_gray");
    public static final UITexture PICTURE_GAUGE = UITexture.fullImage(MODID, "gui/picture/gauge");
    public static final UITexture PICTURE_ITEM_IN = UITexture.fullImage(MODID, "gui/picture/item_in");
    public static final UITexture PICTURE_ITEM_OUT = UITexture.fullImage(MODID, "gui/picture/item_out");
    public static final UITexture PICTURE_FLUID_IN = UITexture.fullImage(MODID, "gui/picture/fluid_in");
    public static final UITexture PICTURE_FLUID_OUT = UITexture.fullImage(MODID, "gui/picture/fluid_out");
}
