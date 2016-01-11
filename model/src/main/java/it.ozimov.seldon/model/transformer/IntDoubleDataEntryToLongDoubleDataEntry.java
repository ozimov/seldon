package it.ozimov.seldon.model.transformer;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import javax.annotation.Nonnull;

import it.ozimov.seldon.model.primitive.DoubleDoubleDataEntry;
import it.ozimov.seldon.model.primitive.IntDoubleDataEntry;

public class IntDoubleDataEntryToLongDoubleDataEntry implements Function<IntDoubleDataEntry, DoubleDoubleDataEntry> {

    @Override
    public DoubleDoubleDataEntry apply(@Nonnull final IntDoubleDataEntry dataEntry) {
        requireNonNull(dataEntry);

        return new DoubleDoubleDataEntry(dataEntry.x(), dataEntry.y());
    }

}
