package it.ozimov.seldon.model.primitive;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.annotations.SafelyConvertable;
import it.ozimov.seldon.model.annotations.SafelyConvertable.None;

@SafelyConvertable(to = None.class)
public class DoubleDoubleDataEntry implements DataEntry, Comparable<DoubleDoubleDataEntry> {

    private double x;
    private double y;

    public DoubleDoubleDataEntry(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value associated with this entry podouble for the independent variable.
     *
     * @return  a value for the independent variable.
     */
    public double x() {
        return x;
    }

    /**
     * Returns the time associated with this entry podouble for the dependent variable.
     *
     * @return  a value for the dependent variable.
     */
    public double y() {
        return y;
    }

    /**
     * Compares two {@linkplain DataEntry} podoubles. The comparison is made first by value of the independent variable
     * (the smallest comes first) and then by value of the dependent variable (the smallest comes first).
     *
     * @param   entryPodouble  the entry podouble for the comparison.
     *
     * @return  <code>-1</code> if <code>this</code> comes before <code>entryPodouble</code>, <code>1</code> if it comes
     *          after, <code>0</code> otherwise.
     */
    @Override
    public int compareTo(@Nonnull final DoubleDoubleDataEntry entryPodouble) {
        requireNonNull(entryPodouble);

        final int xAxisComparison = Double.compare(this.x(), entryPodouble.x());
        if (xAxisComparison == 0) {
            return Double.compare(this.y(), entryPodouble.y());
        }

        return xAxisComparison;
    }

}
