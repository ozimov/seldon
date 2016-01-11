package it.ozimov.seldon.model.primitive;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.annotations.SafelyConvertable;

@SafelyConvertable(to = {DoubleDoubleDataEntry.class, LongDoubleDataEntry.class})
public class IntDoubleDataEntry implements DataEntry, Comparable<IntDoubleDataEntry> {

    private int x;
    private double y;

    public IntDoubleDataEntry(final int x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value associated with this entry point for the independent variable.
     *
     * @return  a value for the independent variable.
     */
    public int x() {
        return x;
    }

    /**
     * Returns the time associated with this entry point for the dependent variable.
     *
     * @return  a value for the dependent variable.
     */
    public double y() {
        return y;
    }

    /**
     * Compares two {@linkplain DataEntry} points. The comparison is made first by value of the independent variable
     * (the smallest comes first) and then by value of the dependent variable (the smallest comes first).
     *
     * @param   entryPoint  the entry point for the comparison.
     *
     * @return  <code>-1</code> if <code>this</code> comes before <code>entryPoint</code>, <code>1</code> if it comes
     *          after, <code>0</code> otherwise.
     */
    @Override
    public int compareTo(@Nonnull final IntDoubleDataEntry entryPoint) {
        requireNonNull(entryPoint);

        final int xAxisComparison = Integer.compare(this.x(), entryPoint.x());
        if (xAxisComparison == 0) {
            return Double.compare(this.y(), entryPoint.y());
        }

        return xAxisComparison;
    }

}
