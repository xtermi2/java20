package com.github.xtermi2.java20.jep432recordpatterns;

import com.github.xtermi2.java20.jep432recordpatterns.RecordPatternMatching.Color;
import com.github.xtermi2.java20.jep432recordpatterns.RecordPatternMatching.ColoredPoint;
import com.github.xtermi2.java20.jep432recordpatterns.RecordPatternMatching.Point;
import com.github.xtermi2.java20.jep432recordpatterns.RecordPatternMatching.Rectangle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RecordPatternMatchingTest {


    @Test
    void printSum_should_return_sum_when_point_is_given() {
        Object o = new RecordPatternMatching.Point<>(2, 5);

        final int sum = RecordPatternMatching.printSum(o);

        assertThat(sum)
                .isEqualTo(7);
    }

    @Test
    void printSum_should_return_default_on_unknown_type() {
        Object o = "foo";

        final int sum = RecordPatternMatching.printSum(o);

        assertThat(sum)
                .isEqualTo(-1);
    }

    @Test
    void printSumGeneric_should_return_sum_when_point_is_given() {
        var o = new Point<>(2, 5);

        final int sum = RecordPatternMatching.printSumGeneric(o);

        assertThat(sum)
                .isEqualTo(7);
    }

    @Test
    void printColorOfUpperLeftPoint_suould_deconstruct_nested_records() {
        var rec = new Rectangle(
                new ColoredPoint(new Point<Integer>(1, 2), Color.BLUE),
                new ColoredPoint(new Point<Integer>(10, 20), Color.GREEN));

        final Color color = RecordPatternMatching.printColorOfUpperLeftPoint(rec);

        assertThat(color)
                .isEqualTo(Color.BLUE);
    }

    @Test
    void dump_should_print_point_array() {
        final var pointArray = new Point[]{
                new Point<>(1, 2),
                new Point<>(4, 4),
                new Point<>(1.1, 2.2)};

        assertThatCode(() -> RecordPatternMatching.dump(pointArray))
                .doesNotThrowAnyException();
    }
}