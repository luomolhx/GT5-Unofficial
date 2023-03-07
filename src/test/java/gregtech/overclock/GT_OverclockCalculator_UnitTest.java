package gregtech.overclock;

import static gregtech.api.enums.GT_Values.V;
import static gregtech.api.enums.GT_Values.VP;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gregtech.api.util.GT_OverclockCalculator;

class GT_OverclockCalculator_UnitTest {

    private static final String messageDuration = "Duration Calculated Wrong";
    private static final String messageEUt = "EUt Calculated Wrong";

    @Test
    void fullPerfectOverclockEBF_Test() {
        int heatDiscounts = (1800 * 4) / 900;
        long correctConsumption = (long) Math.ceil(VP[5] * Math.pow(0.95, heatDiscounts));
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[5])
                .setDuration(1024).enableHeatOC().enableHeatDiscount().setRecipeHeat(1800).setMultiHeat(1800 * 5)
                .calculate();
        assertEquals(1024 >> 8, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void imperfectOverclockEBFWithOneHeatDiscount_Test() {
        int heatDiscounts = 1;
        long correctConsumption = (long) Math.ceil(VP[5] * Math.pow(0.95, heatDiscounts));
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[5])
                .setDuration(1024).enableHeatOC().enableHeatDiscount().setRecipeHeat(1800).setMultiHeat(2700)
                .calculate();
        assertEquals(1024 >> 4, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void imperfectOverclockEBFWithoutHeatDiscounts_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[5])
                .setDuration(1024).enableHeatOC().enableHeatDiscount().setRecipeHeat(1800).setMultiHeat(1800)
                .calculate();
        assertEquals(1024 >> 4, calculator.getDuration(), messageDuration);
        assertEquals(VP[5], calculator.getConsumption(), messageEUt);
    }

    @Test
    void perfectAndImperfectOverclockEBFWithTwoHeatDiscounts_Test() {
        int heatDiscounts = 2;
        long correctConsumption = (long) Math.ceil(VP[5] * Math.pow(0.95, heatDiscounts));
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[5])
                .setDuration(1024).enableHeatOC().enableHeatDiscount().setRecipeHeat(1800).setMultiHeat(3600)
                .calculate();
        assertEquals(1024 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void generalImperfectOverclock_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setDuration(1024).calculate();
        assertEquals(1024 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(VP[6], calculator.getConsumption(), messageEUt);
    }

    @Test
    void generalPerfectOverclock_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setDuration(2048).enablePerfectOC().calculate();
        assertEquals(2048 >> 10, calculator.getDuration(), messageDuration);
        assertEquals(VP[6], calculator.getConsumption(), messageEUt);
    }

    @Test
    void weirdHeatEBF_Test() {
        int heatDiscounts = 3;
        long correctConsumption = (long) Math.ceil(VP[6] * Math.pow(0.95, heatDiscounts));
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setDuration(2048).enableHeatOC().enableHeatDiscount().setRecipeHeat(486).setMultiHeat(3900)
                .calculate();
        assertEquals(2048 >> 6, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void doubleEnergyHatchOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6] + V[6])
                .setAmperage(2).setDuration(1024).calculate();
        assertEquals(1024 >> 6, calculator.getDuration(), messageDuration);
        assertEquals(VP[7], calculator.getConsumption(), messageEUt);
    }

    @Test
    void multiAmpHatchOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setAmperage(256).setDuration(1024).calculate();
        assertEquals(1024 >> 9, calculator.getDuration(), messageDuration);
        assertEquals(VP[10], calculator.getConsumption(), messageEUt);
    }

    @Test
    void weirdAmpHatchOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setAmperage(320).setDuration(1024).calculate();
        assertEquals(1024 >> 9, calculator.getDuration(), messageDuration);
        assertEquals(VP[10], calculator.getConsumption(), messageEUt);
    }

    @Test
    void parallelImperfectOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[8]).setAmperage(4)
                .setDuration(1024).setParallel(16).calculate();
        assertEquals(1024 >> 6, calculator.getDuration(), messageDuration);
        assertEquals(VP[9], calculator.getConsumption(), messageEUt);
    }

    @Test
    void parallelPerfectOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[8]).setAmperage(4)
                .setDuration(4096).setParallel(16).enablePerfectOC().calculate();
        assertEquals(4096 >> 12, calculator.getDuration(), messageDuration);
        assertEquals(VP[9], calculator.getConsumption(), messageEUt);
    }

    @Test
    void parallelMultiAmpOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setAmperage(320).setDuration(1024).setParallel(16).calculate();
        assertEquals(1024 >> 7, calculator.getDuration(), messageDuration);
        assertEquals(VP[10], calculator.getConsumption(), messageEUt);
    }

    @Test
    void weirdParallelOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[8])
                .setDuration(1024).setParallel(8).calculate();
        assertEquals(1024 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(VP[6] * 8, calculator.getConsumption(), messageEUt);
    }

    @Test
    void weirdParallelAndAmpsOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[8])
                .setAmperage(320).setDuration(1024).setParallel(8).calculate();
        assertEquals(1024 >> 9, calculator.getDuration(), messageDuration);
        assertEquals(VP[6] * 8 * 256, calculator.getConsumption(), messageEUt);
    }

    @Test
    void weirdTimeOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setDuration(77).calculate();
        assertEquals(77 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(VP[6], calculator.getConsumption(), messageEUt);
    }

    @Test
    void stopsCorrectlyWhenOneTicking_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6]).setDuration(1)
                .calculate();
        assertEquals(1, calculator.getDuration(), messageDuration);
        assertEquals(VP[1], calculator.getConsumption(), messageEUt);
    }

    @Test
    void imperfectOCWithEUtDiscount_Test() {
        long correctConsumption = (long) Math.ceil(VP[1] * 0.9f) << 10;
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setEUtDiscount(0.9f).setDuration(1024).calculate();
        assertEquals(1024 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void perfectOCWithEUtDiscount_Test() {
        long correctConsumption = (long) Math.ceil(VP[1] * 0.9f) << 10;
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setEUtDiscount(0.9f).setDuration(1024).enablePerfectOC().calculate();
        assertEquals(1024 >> 10, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void imperfectOCWithSpeedBoost_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setSpeedBoost(0.9f).setDuration(1024).calculate();
        assertEquals((int) (1024 * 0.9f) >> 5, calculator.getDuration(), messageDuration);
        assertEquals(VP[6], calculator.getConsumption(), messageEUt);
    }

    @Test
    void perfectOCWithSpeedBoost_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setSpeedBoost(0.9f).setDuration(2048).enablePerfectOC().calculate();
        assertEquals((int) (2048 * 0.9f) >> 10, calculator.getDuration(), messageDuration);
        assertEquals(VP[6], calculator.getConsumption(), messageEUt);
    }

    @Test
    void oneTickDiscountTurnsToOne_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6]).setDuration(1)
                .enableOneTickDiscount().calculate();
        assertEquals(1, calculator.getDuration(), messageDuration);
        assertEquals(1, calculator.getConsumption(), messageEUt);
    }

    @Test
    void oneTickDiscountImperfectOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setSpeedBoost(1.1f).setDuration(4).enableOneTickDiscount().calculate();
        assertEquals(1, calculator.getDuration(), messageDuration);
        assertEquals(480 >> 3, calculator.getConsumption(), messageEUt);
    }

    @Test
    void oneTickDiscountPerfectOC_Test() {
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[1]).setEUt(V[6])
                .setSpeedBoost(1.1f).setDuration(16).enablePerfectOC().enableOneTickDiscount().calculate();
        assertEquals(1, calculator.getDuration(), messageDuration);
        assertEquals(480 >> 6, calculator.getConsumption(), messageEUt);
    }

    @Test
    void ulvRecipeWithDiscount_Test() {
        long correctConsumption = (long) Math.ceil((VP[0] << 10) * 0.9f);
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[0]).setEUt(V[6])
                .setEUtDiscount(0.9f).setDuration(1024).calculate();
        assertEquals(1024 >> 5, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }

    @Test
    void ulvRecipeWithDiscountWithParallel_Test() {
        long correctConsumption = (long) Math.ceil((VP[0] << 6) * 14 * 0.9f);
        GT_OverclockCalculator calculator = new GT_OverclockCalculator().setRecipeEUt(VP[0]).setEUt(V[5])
                .setEUtDiscount(0.9f).setParallel(14).setDuration(1024).calculate();
        assertEquals(1024 >> 3, calculator.getDuration(), messageDuration);
        assertEquals(correctConsumption, calculator.getConsumption(), messageEUt);
    }
}
