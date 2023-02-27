package com.github.xtermi2.java20.jep433patternmatching;

import com.github.xtermi2.java20.jep433patternmatching.SwitchPatternMatching.MyPair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchPatternMatchingTest {

    @Test
    void recordInference() {
        final MyPair<String, Integer> pair = new MyPair<>("Str", 4);

        final String res = SwitchPatternMatching.recordInference(pair);

        assertThat(res)
                .isEqualTo("MyPair(Str,4)");
    }

    @ParameterizedTest
    @CsvSource({
            "-2,All the remaining integers",
            "-1,Special cases",
            "0,All the remaining integers",
            "1,Special cases",
            "2,Positive integer cases",
    })
    void labelWithGuard(int i, String expected) {
        assertThat(SwitchPatternMatching.labelWithGuard(i))
                .isEqualTo(expected);
    }
}