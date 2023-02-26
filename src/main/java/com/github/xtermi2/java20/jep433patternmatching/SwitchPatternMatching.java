package com.github.xtermi2.java20.jep433patternmatching;

public class SwitchPatternMatching {

    record MyPair<S, T>(S fst, T snd) {
    }

    static String recordInference(MyPair<String, Integer> pair) {
        return switch (pair) {
            case MyPair(var f, var s) -> "MyPair(" + f + "," + s + ")";
        };
    }

    static String labelWithGuard(Integer integer) {
        return switch (integer) {
            case -1, 1 -> "Special cases";
            case Integer i
                    when i > 0 -> "Positive integer cases";
            case Integer ignored -> "All the remaining integers";
        };
    }
}
