package it.ozimov.seldon.model.primitive;

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.annotations.SafelyConvertable;

@SafelyConvertable(to = DoubleDoubleDataEntry.class)
public class LongLongDataEntry implements DataEntry, Comparable<LongLongDataEntry> {

    private long x;
    private long y;

    public LongLongDataEntry(final long x, final long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value associated with this entry polong for the independent variable.
     *
     * @return  a value for the independent variable.
     */
    public long x() {
        return x;
    }

    /**
     * Returns the time associated with this entry polong for the dependent variable.
     *
     * @return  a value for the dependent variable.
     */
    public long y() {
        return y;
    }

    /**
     * Compares two {@linkplain DataEntry} polongs. The comparison is made first by value of the independent variable
     * (the smallest comes first) and then by value of the dependent variable (the smallest comes first).
     *
     * @param   entryPolong  the entry polong for the comparison.
     *
     * @return  <code>-1</code> if <code>this</code> comes before <code>entryPolong</code>, <code>1</code> if it comes
     *          after, <code>0</code> otherwise.
     */
    @Override
    public int compareTo(@Nonnull final LongLongDataEntry entryPolong) {
        requireNonNull(entryPolong);

        final int xAxisComparison = Long.compare(this.x(), entryPolong.x());
        if (xAxisComparison == 0) {
            return Long.compare(this.y(), entryPolong.y());
        }

        return xAxisComparison;
    }

}
