package it.ozimov.seldon.core.algorithms.forecast;

import static java.util.Objects.requireNonNull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.SortedMap;

import javax.annotation.Nonnull;

import it.ozimov.seldon.core.algorithms.Algorithm;
import it.ozimov.seldon.core.algorithms.LoggedAlgorithm;
import it.ozimov.seldon.math.annotations.Positive;

import it.unimi.dsi.fastutil.BigList;

/**
 * Abstract implementation of a forecasting algorithm that extends the class {@linkplain LoggedAlgorithm}.
 *
 * @version  0.1.0
 * @since    0.1.0
 */
public abstract class LoggedForecastAlgorithm<H extends SortedMap<? extends Number, ? extends Number>, F extends BigList>
    extends LoggedAlgorithm<F> implements ForecastAlgorithm<H, F> {

    protected H history;

    protected long futureValues;
    private boolean lookaheadIsSet;

    protected LoggedForecastAlgorithm(@Nonnull final H history) {
        requireNonNull(history);

        withHistory(history);
    }

    /**
     * {@inheritDoc}
     */
    public Algorithm<F> withHistory(@Nonnull final H history) {
        this.history = history;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Algorithm<F> withLookahead(@Positive final long futureValues) {
        checkArgument(futureValues > 0, "futureValues cannot be negative or zero");

        this.futureValues = futureValues;
        lookaheadIsSet = true;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public F getOutput() {
        checkState(lookaheadIsSet, "The algorithm parameter lookahead is not set through withLookahead method");

        return forecast(futureValues);
    }

    /**
     * When method {@linkplain #getOutput()} is called, then this method has to be executed to compute the forecast with
     * the given parameters.
     *
     * @param   futureValues  the number of points requested for the forecast.
     *
     * @return  the forecast
     */
    protected abstract F forecast(@Positive final long futureValues);
}
