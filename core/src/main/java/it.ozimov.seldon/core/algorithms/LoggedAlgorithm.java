package it.ozimov.seldon.core.algorithms;

import static it.ozimov.seldon.core.algorithms.AlgorithmExecutionState.COMPLETED;
import static it.ozimov.seldon.core.algorithms.AlgorithmExecutionState.CREATED;
import static it.ozimov.seldon.core.algorithms.AlgorithmExecutionState.ERROR;
import static it.ozimov.seldon.core.algorithms.AlgorithmExecutionState.STARTED;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;

/**
 * @param    <T>
 *
 * @version  0.1.0
 * @since    0.1.0
 */
public abstract class LoggedAlgorithm<T> implements Algorithm<T> {

    private static final Logger LOG = LoggerFactory.getLogger(LoggedAlgorithm.class);

    protected Stopwatch stopwatch;

    protected long runtime;

    protected AlgorithmExecutionState executionState = CREATED;

    /**
     * {@inheritDoc}
     *
     * <p>Executes logging on execution started and when it is completed. Moreover, logs errors. The status of the
     * algorithm is set to {@linkplain AlgorithmExecutionState#STARTED} when the method is called,
     * {@linkplain AlgorithmExecutionState#COMPLETED} when the execution ends and
     * {@linkplain AlgorithmExecutionState#ERROR} if an exception is thrown.
     *
     * <p>The log also includes the runtime in the unit of measure provided by
     * {@linkplain LoggedAlgorithm#getRuntimeTimeUnit()}.
     */
    public Algorithm<T> execute() {
        executionState = CREATED;
        logOnStart();
        stopwatch = Stopwatch.createStarted();
        executionState = STARTED;
        try {
            compute();
        } catch (final Throwable throwable) {
            executionState = ERROR;
            runtime = stopwatch.elapsed(getRuntimeTimeUnit());
            logOnError(throwable);
        }

        executionState = COMPLETED;
        runtime = stopwatch.elapsed(getRuntimeTimeUnit());
        logOnEnd();
        return this;
    }

    /**
     * Returns the current state of the algorithm, as defined by the enum {@linkplain AlgorithmExecutionState}.
     *
     * @return  the state
     */
    public AlgorithmExecutionState getCurrentState() {
        return executionState;
    }

    /**
     * Computes anything necessary to calculate the output from this algorithm.
     *
     * @return  this instance.
     */
    protected abstract Algorithm<T> compute();

    /**
     * Log a message on execution start. Default logging message is {@code "Algorithm {$algorithm-name} started"}, where
     * {@code {$algorithm-name}} is the name of the algorithm as defined by the {@linkplain Algorithm#algorithmName()}.
     */
    protected void logOnStart() {
        LOG.info("Algorithm {} started", algorithmName());
    }

    /**
     * Log a message at the end of the execution. Default logging message is {@code "Algorithm {$algorithm-name} ended
     * after {$run-time}{$unit-measure}"}, where {@code {$algorithm-name}} is the name of the algorithm as defined by
     * the {@linkplain Algorithm#algorithmName()}, {@code {$run-time}} is the execution time of the algorithm obtained
     * by using method {@linkplain LoggedAlgorithm#getRuntime()} and {@code {$unit-measure}} is the unit measure for the
     * execution time of the algorithm obtained by using method {@linkplain LoggedAlgorithm#getRuntimeTimeUnit()}.
     */
    protected void logOnEnd() {
        LOG.error("Algorithm {} ended after {}{}.", algorithmName(), getRuntime(), getRuntimeTimeUnit().name());
    }

    /**
     * Log a message if an exception is thrown by method {@linkplain LoggedAlgorithm#compute()} at the end of the
     * execution. Default logging message is {@code "Algorithm {$algorithm-name} failed after
     * {$run-time}{$unit-measure}"} (plus the exception specific error message and stacktrace), where
     * {@code {$algorithm-name}} is the name of the algorithm as defined by the {@linkplain Algorithm#algorithmName()},
     * {@code {$run-time}} is the execution time of the algorithm obtained by using method
     * {@linkplain LoggedAlgorithm#getRuntime()} and {@code {$unit-measure}} is the unit measure for the execution time
     * of the algorithm obtained by using method {@linkplain LoggedAlgorithm#getRuntimeTimeUnit()}.
     */
    protected void logOnError(@Nonnull final Throwable throwable) {
        LOG.error("Algorithm {} failed after {}{}.", algorithmName(), getRuntime(), getRuntimeTimeUnit().name(),
            throwable);
    }

    /**
     * Returns the {@linkplain TimeUnit} used to define the runtime. Default value is {@linkplain TimeUnit#MILLISECONDS}.
     *
     * @return  the time unit set for this instance.
     */
    protected TimeUnit getRuntimeTimeUnit() {
        return TimeUnit.MILLISECONDS;
    }

    /**
     * Returns the runtime of the algorithm, based on the @linkplain TimeUnit} returned by method
     * {@linkplain LoggedAlgorithm#getRuntimeTimeUnit()}. Default value is measured in milliseconds.
     *
     * @return  the runtime for this algorithm execution.
     */
    protected long getRuntime() {
        return runtime;
    }

}
