package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.LongIntDataEntry;
import it.ozimov.seldon.model.primitive.LongLongDataEntry;

public class LongIntDataEntryToLongLongDataEntry implements Function<LongIntDataEntry, LongLongDataEntry> {

    @Override
    public LongLongDataEntry apply(@Nonnull final LongIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new LongLongDataEntry(dataEntry.x(), dataEntry.y());
    }

}
