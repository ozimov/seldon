package it.ozimov.seldon.core.algorithms.rounding;

import static java.lang.StrictMath.round;

import javax.annotation.Nonnull;

import it.ozimov.seldon.core.algorithms.Algorithm;

import it.unimi.dsi.fastutil.floats.FloatBigArrayBigList;
import it.unimi.dsi.fastutil.ints.IntBigArrayBigList;

/**
 * @version  0.1.0
 * @since    0.1.0
 */
public class FloatToIntCumulativeRoundingForecastAlgorithm
    extends CumulativeRoundingForecastAlgorithm<FloatBigArrayBigList, IntBigArrayBigList> {

    private FloatToIntCumulativeRoundingForecastAlgorithm(@Nonnull final FloatBigArrayBigList fromBigList) {
        super(fromBigList);
    }

    /**
     * Fluent accessor to the default constructor.
     *
     * @return  a new instance of the class.
     */
    @Nonnull
    public static FloatToIntCumulativeRoundingForecastAlgorithm cumulativeRoundingAlgorithm(
            @Nonnull final FloatBigArrayBigList fromBigList) {
        return new FloatToIntCumulativeRoundingForecastAlgorithm(fromBigList);
    }

    /**
     */
    @Override
    protected Algorithm<IntBigArrayBigList> compute() {
        final long size = fromBigList.size64();
        final IntBigArrayBigList intArrayList = new IntBigArrayBigList(size);

        float d = .0f;
        for (long i = 0L; i < size; i++) {
            final int roundedValue = round(fromBigList.getFloat(i) + d + .5f);
            d += fromBigList.getFloat(i) - roundedValue;
            intArrayList.add(roundedValue);
        }

        toBigList = intArrayList;
        return this;
    }

    @Override
    public IntBigArrayBigList apply(@Nonnull final FloatBigArrayBigList fromBigList) {
        return compute().getOutput();
    }

}
