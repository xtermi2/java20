![Java CI](https://github.com/xtermi2/java20/workflows/Java%20CI/badge.svg)

# Schedule

- 2023/03/21 General Availability

# Java 20 Features

- [JEP 429: Scoped Values (Incubator)](https://openjdk.org/jeps/429)
    - Enable the sharing of immutable data within and across threads. They are preferred to thread-local variables,
      especially when using large numbers of virtual threads.
    - Unlike a thread-local variable, a scoped value is written once and is then immutable, and is available only for a
      bounded period during execution of the thread.
    - see example `ScopedValueServer.java`
- [JEP 432: Record Patterns (Second Preview)](https://openjdk.org/jeps/432)
    - Enhance the Java programming language with record patterns to deconstruct record values.
    - The main changes since the 3rd preview are:
        - Add support for inference of type arguments of generic record patterns.
        - Add support for record patterns to appear in the header of an enhanced for statement.
    - see example `RecordPatternMatching.java`
- [JEP 433: Pattern Matching for switch (Fourth Preview)](https://openjdk.java.net/jeps/433)
    - The main changes since the 3rd preview are:
        - The grammar for switch labels is simpler.
        - Inference of type arguments for generic record patterns is now supported in switch expressions and statements,
          along with the other constructs that support patterns.
    - see example `SwitchPatternMatching.java`
- [JEP 434: Foreign Function & Memory API (Second Preview)](https://openjdk.java.net/jeps/434)
    - Introduce an API by which Java programs can interoperate with code and data outside of the Java runtime.
      Combination of 2 APIs introduced in previous JDKs:
    - Foreign-Memory Access API (incubator in 14, 15 and 16)
    - Foreign Linker API (incubator in 16)
    - The main changes since the first preview are:
        - The `MemorySegment` and `MemoryAddress` abstractions are unified (memory addresses are now modeled by
          zero-length memory segments).
        - The sealed `MemoryLayout` hierarchy is enhanced to facilitate usage with pattern matching in switch
          expressions and statements (JEP 433).
        - `MemorySession` has been split into `Arena` and `SegmentScope` to facilitate sharing segments across
          maintenance boundaries.
    - see example `ForeignFunctionAndMemoryAPI.java`
- [JEP 436:	Virtual Threads (Second Preview)](https://openjdk.java.net/jeps/436)
    - Virtual threads are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications.
    - Minor changes since the first preview:
      - Some changes made in the first preview were made permanent in JDK 19 because they involve functionality that is broadly useful and is not specific to virtual threads.
    - see example `VirtualThreads.java`


##### Other References

- https://openjdk.org/projects/jdk/20/
