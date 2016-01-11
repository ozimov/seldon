package it.ozimov.seldon.tools.memorymanagement.performance;

/**
 * Interface for all the classes.
 */
public interface GrowingDataStructure {

    void registerMemoryManager();

    void deleteIfPersisted();

}
