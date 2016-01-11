package it.ozimov.seldon.model.transformer;

import it.ozimov.seldon.model.primitive.DoubleDoubleDataEntry;
import it.ozimov.seldon.model.primitive.LongLongDataEntry;

import javax.annotation.Nonnull;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

public class LongLongDataEntryToDoubleDoubleDataEntry implements Function<LongLongDataEntry, DoubleDoubleDataEntry> {

    @Override
    public DoubleDoubleDataEntry apply(@Nonnull final LongLongDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new DoubleDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
