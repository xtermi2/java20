package com.github.xtermi2.java20.jep432recordpatterns;

public class RecordPatternMatching {

    record Point<T extends Number>(T x, T y) {
    }

    enum Color {RED, GREEN, BLUE}

    record ColoredPoint(Point<?> p, Color c) {
    }

    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {
    }

    static int printSum(Object o) {
        if (o instanceof Point(var x, var y)) {
            final int sum = x.intValue() + y.intValue();
            System.out.println(sum);
            return sum;
        }
        return -1;
    }

    static int printSumGeneric(Point<Integer> o) {
        if (o instanceof Point<Integer>(var x, var y)) {
            final int sum = x + y;
            System.out.println(sum);
            return sum;
        }
        return -1;
    }

    static Color printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point<?>(Integer x, Integer y), Color c),
                ColoredPoint lr
        )) {
            System.out.println("upperLeft: " + c + " (" + x + "," + y + ")");
            return c;
        }
        return null;
    }

    static void dump(Point<?>[] pointArray) {
        System.out.println("dump ...");
        // deconstructing in for loop
        for (Point(var x, var y) : pointArray) {
            System.out.println("(" + x + "," + y + ")");
        }
        System.out.println("... finished!");
    }
}
