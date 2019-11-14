package com.bsu.testing;

class Triangle {

    private static final String EXCEPTION = "Triangle has zero or negative side.";

    static boolean isTriangleExist(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException(EXCEPTION);
        return a < b + c && b < a + c && c < a + b;
    }
}
