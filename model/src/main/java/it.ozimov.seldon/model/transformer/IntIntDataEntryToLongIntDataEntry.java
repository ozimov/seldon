package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.IntIntDataEntry;
import it.ozimov.seldon.model.primitive.LongIntDataEntry;

public class IntIntDataEntryToLongIntDataEntry implements Function<IntIntDataEntry, LongIntDataEntry> {

    @Override
    public LongIntDataEntry apply(@Nonnull final IntIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongIntDataEntry(dataEntry.x(), dataEntry.y());
    }

}
