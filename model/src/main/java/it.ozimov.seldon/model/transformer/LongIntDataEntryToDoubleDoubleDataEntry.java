package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.DoubleDoubleDataEntry;
import it.ozimov.seldon.model.primitive.LongIntDataEntry;

public class LongIntDataEntryToDoubleDoubleDataEntry implements Function<LongIntDataEntry, DoubleDoubleDataEntry> {

    @Override
    public DoubleDoubleDataEntry apply(@Nonnull final LongIntDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new DoubleDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
