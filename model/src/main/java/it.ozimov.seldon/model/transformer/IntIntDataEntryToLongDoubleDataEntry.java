package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.IntIntDataEntry;
import it.ozimov.seldon.model.primitive.LongDoubleDataEntry;

public class IntIntDataEntryToLongDoubleDataEntry implements Function<IntIntDataEntry, LongDoubleDataEntry> {

    @Override
    public LongDoubleDataEntry apply(@Nonnull final IntIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
