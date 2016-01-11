package it.ozimov.seldon.core.algorithms.forecast;

import java.util.SortedMap;

import javax.annotation.Nonnull;

import it.ozimov.seldon.core.algorithms.Algorithm;
import it.ozimov.seldon.math.annotations.Positive;

import it.unimi.dsi.fastutil.BigList;

/**
 * Interface for a forecast algorithm.
 *
 * @param    <H>  the map of history values. Suggested classes to be used are
 *                {@linkplain it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap},
 *                {@linkplain it.unimi.dsi.fastutil.longs.Long2DoubleLinkedOpenHashMap}, etc.
 * @param    <F>  the {@linkplain BigList} with the forecasted values
 *
 * @version  0.1.0
 * @since    0.1.0
 */
public interface ForecastAlgorithm<H extends SortedMap<? extends Number, ? extends Number>, F extends BigList>
    extends Algorithm<F> {

    /**
     * Executes computations for the forecast.
     *
     * @return  this instance.
     */
    @Override
    Algorithm<F> execute();

    /**
     * Set the history of data for training the forecast algorithm.
     *
     * @param   history  the data from the history.
     *
     * @return  this instance.
     */
    Algorithm<F> withHistory(@Nonnull H history);

    /**
     * Set the lookahead parameter for the forecast. The parameter {@code futureValues} is the number of points
     * calculated in the future.
     *
     * <p>E.g. in a demand forecast model, assuming that the independent variable in the given hisotry map is a sequence
     * of numbers, then calling {@code withLookahead(12)} returns a monthly forecast fore the next 12 months.
     *
     * @param   futureValues  the number of values to be calculated in the future.
     *
     * @return  this instance.
     */
    Algorithm<F> withLookahead(@Positive long futureValues);

    /**
     * Returns the forecast of the computation for the next future values as defined by method
     * {@linkplain ForecastAlgorithm#withLookahead(long)}.
     *
     * @return  a valid forecast.
     */
    @Override
    F getOutput();

}
