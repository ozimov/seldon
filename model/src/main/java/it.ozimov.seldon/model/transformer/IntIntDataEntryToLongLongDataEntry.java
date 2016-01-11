package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.IntIntDataEntry;
import it.ozimov.seldon.model.primitive.LongLongDataEntry;

public class IntIntDataEntryToLongLongDataEntry implements Function<IntIntDataEntry, LongLongDataEntry> {

    @Override
    public LongLongDataEntry apply(@Nonnull final IntIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongLongDataEntry(dataEntry.x(), dataEntry.y());
    }

}
