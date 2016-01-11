package it.ozimov.seldon.tools.io;

import java.nio.file.Path;

public class SizeInfo {

    public static long size(final Path pathToFile) {
        return pathToFile.toFile().length();
    }

}
