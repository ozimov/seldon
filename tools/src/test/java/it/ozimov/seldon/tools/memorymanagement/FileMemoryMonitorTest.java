package it.ozimov.seldon.tools.memorymanagement;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileMemoryMonitorTest {

    @Test
    public void testTotalSpace() throws Exception {
        System.out.println(FileMemoryMonitor.totalSpace());
    }

    @Test
    public void testUnallocatedSpace() throws Exception {
        System.out.println(FileMemoryMonitor.unallocatedSpace());
    }

    @Test
    public void testAvailableSpace() throws Exception {
        System.out.println(FileMemoryMonitor.availableSpace());
    }

    @Test
    public void testDiskUtilization() throws Exception {

    }

    @Test
    public void testCanLoadInMemory() throws Exception {

    }

    @Test
    public void testCanPersistOnDisk() throws Exception {

    }
}