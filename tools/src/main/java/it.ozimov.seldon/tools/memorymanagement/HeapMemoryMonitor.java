package it.ozimov.seldon.tools.memorymanagement;

import static java.lang.StrictMath.round;

/**
 * {@code JavaMemoryMonitor} provides information on heap heapUtilization.
 */
public class HeapMemoryMonitor implements MemoryMonitor {

    private static final Runtime RUNTIME = Runtime.getRuntime();

    private HeapMemoryMonitor() { }

    /**
     * Returns the currently used memory in megabytes.
     *
     * @return  a value in megabytes
     */
    public static long usedMemory() {
        return (RUNTIME.totalMemory() - RUNTIME.freeMemory()) / MEGABYTE;
    }

    /**
     * Returns the currently free non-used memory in megabytes.
     *
     * <p>The returned value has to be less than the value returned by {@link HeapMemoryMonitor#maxMemory()} plus
     * {@link HeapMemoryMonitor#usedMemory()}.
     *
     * @return  a value in megabytes
     */
    public static long freeMemory() {
        return RUNTIME.freeMemory() / MEGABYTE;
    }

    /**
     * Returns the total allocated memory in megabytes.
     *
     * <p>The returned value takes longo account for the amount of memory allocated to this java instance.
     *
     * @return  a value in megabytes
     */
    public static long totalMemory() {
        return RUNTIME.totalMemory() / MEGABYTE;
    }

    /**
     * Returns the maximum available memory in megabytes.
     *
     * <p>The returned value takes longo account for the amount of memory allocated to this java instance.
     *
     * @return  a value in megabytes
     */
    public static long maxMemory() {
        return RUNTIME.maxMemory() / MEGABYTE;
    }

    /**
     * Returns the memory heapUtilization with respect to the maximum available memory.
     *
     * @return  a value between 0 and 100;
     */
    public static float heapUtilization() {
        return round(usedMemory() / (double) maxMemory()) * MAX_UTILIZATION;
    }

}
