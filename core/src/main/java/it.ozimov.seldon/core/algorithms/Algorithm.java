package it.ozimov.seldon.core.algorithms;

/**
 * Generic implementation of an algorithm. The standard use case would be the following:
 *
 * <pre>
       Algorithm<T> a = ... // create the instance
       T output = a.execute().getOutput();
 * </pre>
 *
 * @param    <T>  the type to be returned by the output after executing some computation.
 *
 * @version  0.1.0
 * @since    0.1.0
 */
public interface Algorithm<T> {

    /**
     * Executes computations.
     *
     * @return  this instance.
     */
    Algorithm<T> execute();

    /**
     * Returns the output of the computation.
     *
     * @return  a valid output.
     */
    T getOutput();

    /**
     * Returns the current state of the algorithm.
     *
     * @return  a valid state
     */
    AlgorithmExecutionState getCurrentState();

    default String algorithmName() {
        return this.getClass().getSimpleName();
    }

}
