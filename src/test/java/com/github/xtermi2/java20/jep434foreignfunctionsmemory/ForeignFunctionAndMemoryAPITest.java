package com.github.xtermi2.java20.jep434foreignfunctionsmemory;

import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static org.assertj.core.api.Assertions.assertThat;

class ForeignFunctionAndMemoryAPITest {
    private final ForeignFunctionAndMemoryAPI underTest = new ForeignFunctionAndMemoryAPI();

    @Test
    void test_of_heap_array() {
        try (Arena arena = Arena.openConfined()) {
            final MemorySegment cDoubleArray = underTest.allocateArrayOffHeap(arena);

            for (long i = 0; i < (4 * 4); i++) {
                if (i > 0 && i % 4 == 0) {
                    System.out.println();
                }
                final double v = cDoubleArray.get(ForeignFunctionAndMemoryAPI.C_DOUBLE, i * 8);
                assertThat(v)
                        .isBetween(0.9, 8.1);
            }
        } // all memory allocated is released here
    }

    @Test
    void call_get_pid() throws Throwable {
        final int pid = underTest.getPid();

        assertThat(pid)
                .isBetween(1, Integer.MAX_VALUE);
    }
}