package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.LongDoubleDataEntry;
import it.ozimov.seldon.model.primitive.LongIntDataEntry;

public class LongIntDataEntryToLongDoubleDataEntry implements Function<LongIntDataEntry, LongDoubleDataEntry> {

    @Override
    public LongDoubleDataEntry apply(@Nonnull final LongIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
