package it.ozimov.seldon.core.algorithms.rounding;

import java.util.function.Function;

import it.ozimov.seldon.core.algorithms.Algorithm;

import it.unimi.dsi.fastutil.BigList;

/**
 * @param    <F>
 * @param    <T>
 *
 * @version  0.1.0
 * @since    0.1.0
 */
public interface RoundingForecastAlgorithm<F extends BigList, T extends BigList> extends Algorithm<T>, Function<F, T> { }
