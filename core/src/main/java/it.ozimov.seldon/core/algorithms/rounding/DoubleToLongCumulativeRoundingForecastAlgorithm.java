package it.ozimov.seldon.core.algorithms.rounding;

import static java.lang.StrictMath.round;

import javax.annotation.Nonnull;

import it.ozimov.seldon.core.algorithms.Algorithm;

import it.unimi.dsi.fastutil.doubles.DoubleBigArrayBigList;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;

/**
 * @version  0.1.0
 * @since    0.1.0
 */
public class DoubleToLongCumulativeRoundingForecastAlgorithm
    extends CumulativeRoundingForecastAlgorithm<DoubleBigArrayBigList, LongBigArrayBigList> {

    private DoubleToLongCumulativeRoundingForecastAlgorithm(@Nonnull final DoubleBigArrayBigList fromBigList) {
        super(fromBigList);
    }

    /**
     * Fluent accessor to the default constructor.
     *
     * @return  a new instance of the class.
     */
    @Nonnull
    public static DoubleToLongCumulativeRoundingForecastAlgorithm cumulativeRoundingAlgorithm(
            @Nonnull final DoubleBigArrayBigList fromBigList) {
        return new DoubleToLongCumulativeRoundingForecastAlgorithm(fromBigList);
    }

    /**
     */
    @Override
    protected Algorithm<LongBigArrayBigList> compute() {
        final long size = fromBigList.size64();
        final LongBigArrayBigList longArrayList = new LongBigArrayBigList(size);

        double d = .0d;
        for (long i = 0L; i < size; i++) {
            final long roundedValue = round(fromBigList.getDouble(i) + d + .5d);
            d += fromBigList.getDouble(i) - roundedValue;
            longArrayList.add(roundedValue);
        }

        toBigList = longArrayList;
        return this;
    }

    @Override
    public LongBigArrayBigList apply(@Nonnull final DoubleBigArrayBigList fromBigList) {
        return compute().getOutput();
    }

}
