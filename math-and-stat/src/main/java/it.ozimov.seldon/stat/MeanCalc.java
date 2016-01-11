package it.ozimov.seldon.stat;

import javax.annotation.Nonnull;

import it.unimi.dsi.fastutil.doubles.DoubleBigArrayBigList;
import it.unimi.dsi.fastutil.floats.FloatBigArrayBigList;
import it.unimi.dsi.fastutil.ints.IntBigArrayBigList;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;

public class MeanCalc {

    private MeanCalc() { }

    public float mean(@Nonnull final FloatBigArrayBigList bigList) {
        final long size = bigList.size64();
        double sum = .0;
        for (int i = 0; i < size; i++) {
            sum += bigList.getFloat(i);
        }

        return (float) (sum / size);
    }

    public double mean(@Nonnull final DoubleBigArrayBigList bigList) {
        final long size = bigList.size64();
        double sum = .0;
        for (int i = 0; i < size; i++) {
            sum += bigList.getDouble(i);
        }

        return sum / size;
    }

    public float mean(@Nonnull final IntBigArrayBigList bigList) {
        final long size = bigList.size64();
        double sum = .0;
        for (int i = 0; i < size; i++) {
            sum += bigList.getInt(i);
        }

        return (float) (sum / size);
    }

    public double mean(@Nonnull final LongBigArrayBigList bigList) {
        final long size = bigList.size64();
        double sum = .0;
        for (int i = 0; i < size; i++) {
            sum += bigList.getLong(i);
        }

        return (sum / size);
    }

}
