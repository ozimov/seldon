package it.ozimov.seldon.core.algorithms.rounding;

import static java.util.Objects.requireNonNull;

import static com.google.common.base.Preconditions.checkState;

import static it.ozimov.seldon.core.algorithms.AlgorithmExecutionState.COMPLETED;

import javax.annotation.Nonnull;

import it.ozimov.seldon.core.algorithms.LoggedAlgorithm;

import it.unimi.dsi.fastutil.BigList;

/**
 * A rounding algorithm that rounds element <em>i</em>th based on the rounding applied to elements <em>1,...,i-1</em>.
 *
 * @version  0.1.0
 * @see      <a href="http://link.springer.com/book/10.1007%2F978-3-319-11976-2">Section 3.4 in "Demand forecasting for
 *           inventory control", N. Thomopoulos, 2015, Springer. DOI: 10.1007/978-3-319-11976-2</a>
 * @since    0.1.0
 */
public abstract class CumulativeRoundingForecastAlgorithm<F extends BigList, T extends BigList>
    extends LoggedAlgorithm<T> implements RoundingForecastAlgorithm<F, T> {

    protected F fromBigList;

    protected T toBigList;

    protected CumulativeRoundingForecastAlgorithm(@Nonnull final F fromBigList) {
        requireNonNull(fromBigList);

        this.fromBigList = fromBigList;
    }

    @Override
    public T getOutput() {
        checkState(executionState == COMPLETED, "The algorithm state is not COMPLETED, cannot access the output");

        return toBigList;
    }
}
