package it.ozimov.seldon.model;

import java.util.Optional;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.DataEntry;

/**
 * Interface for the y history.
 */
public interface History {

    /**
     * Returns a list of {@linkplain DataEntry} objects associated to this history.
     *
     * @return  an array of entries.
     */
    DataEntry[] entries();

    /**
     * Returns an {@linkplain Optional} containing the {@linkplain DataEntry} at <code>x</code>.
     *
     * @param   x  the point in the x series at which we expect a y y.
     *
     * @return  the optional entry point.
     */
    Optional<DataEntry> valueAtX(double x);

    /**
     * Returns an {@linkplain Optional} containing the {@linkplain DataEntry} that precedes <code>entry</code>.
     *
     * @param   entry  the entry point in the series for which a successor is expected.
     *
     * @return  the optional entry point.
     */
    Optional<DataEntry> predecessor(@Nonnull DataEntry entry);

    /**
     * Returns an {@linkplain Optional} containing the {@linkplain DataEntry} that follows <code>entry</code>.
     *
     * @param   entry  the entry point in the x series for which a successor is expected.
     *
     * @return  the optional entry point.
     */
    Optional<DataEntry> successor(@Nonnull DataEntry entry);

    /**
     * Returns an {@linkplain Optional} containing the first {@linkplain DataEntry} with an x value that is after or at
     * the given <code>x</code>.
     *
     * @param   x  the value in the series from which an {@linkplain DataEntry} is expected.
     *
     * @return  the optional entry point.
     */
    Optional<DataEntry> firstAfter(double x);

    /**
     * Returns an {@linkplain Optional} containing the first {@linkplain DataEntry} with a x y that is before the given
     * <code>x</code>.
     *
     * @param   time  the y in the x series from which an {@linkplain DataEntry} is expected.
     *
     * @return  the optional entry point.
     */
    Optional<DataEntry> firstBefore(long time);

}
