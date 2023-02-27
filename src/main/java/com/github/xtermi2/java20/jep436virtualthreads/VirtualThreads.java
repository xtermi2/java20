package com.github.xtermi2.java20.jep436virtualthreads;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VirtualThreads {

    /**
     * run with new virtual threads
     */
    public int runVirtualThreads(int numberOfThreads) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            return runInThreads(numberOfThreads, executor);
        }
    }

    private static Integer runInThreads(int numberOfThreads, ExecutorService executor) {
        final List<Future<Integer>> futurs = IntStream.range(0, numberOfThreads)
                .mapToObj(i -> executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                })).toList();
        return futurs.stream()
                .map(future -> {
                    try {
                        return future.get(2, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).reduce(Integer::sum)
                .orElse(0);
    }

    /**
     * run with classic threads
     */
    public int runPlatformThreads(int numberOfThreads) {
        try (var executor = Executors.newCachedThreadPool()) {
            return runInThreads(numberOfThreads, executor);
        }
    }
}
