package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.IntDoubleDataEntry;
import it.ozimov.seldon.model.primitive.LongDoubleDataEntry;

public class IntDoubleDataEntryToDoubleDoubleDataEntry implements Function<IntDoubleDataEntry, LongDoubleDataEntry> {

    @Override
    public LongDoubleDataEntry apply(@Nonnull final IntDoubleDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
