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
    - TODO
    - see example `SwitchPatternMatching.java`
    - The main changes since the 3rd preview are:
        - The grammar for switch labels is simpler.
        - Inference of type arguments for generic record patterns is now supported in switch expressions and statements,
          along with the other constructs that support patterns.
- TODO

##### Other References

- https://openjdk.org/projects/jdk/20/
