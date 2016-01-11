package it.ozimov.seldon.tools.io;

import java.nio.file.Path;

import javax.annotation.Nonnull;

public interface InputDataReader {

    void readString(@Nonnull String formattedText);

    void readCSV(@Nonnull Path filePath);

}
