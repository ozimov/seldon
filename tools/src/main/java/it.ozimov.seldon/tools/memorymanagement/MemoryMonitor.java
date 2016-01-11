package it.ozimov.seldon.tools.memorymanagement;

public interface MemoryMonitor {

    long MEGABYTE = 1024 * 1024;

    float SAFETY_THRESHOLD = .9f;

    float MAX_UTILIZATION = 100f;
}
