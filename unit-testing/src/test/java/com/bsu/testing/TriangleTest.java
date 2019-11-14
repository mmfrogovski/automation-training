package com.bsu.testing;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void rightTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(3, 4, 5));
    }

    @Test
    public void equilateralTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(1, 1, 1));
    }

    @Test
    public void isoscelesTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(2, 2, 3));
    }

    @Test
    public void arbitraryTriangle() {
        Assert.assertTrue(Triangle.isTriangleExist(2, 3, 4));
    }

    @Test
    public void oneSideEqualSumOfOtherSides() {
        Assert.assertFalse(Triangle.isTriangleExist(2, 1, 1));
    }


    @Test
    public void oneSideRatherThenSumOfOtherSides() {
        Assert.assertFalse(Triangle.isTriangleExist(4, 1, 2));
    }

    @Test
    public void allNegativeSides() {
        org.testng.Assert.assertThrows(IllegalArgumentException.class, () -> Triangle.isTriangleExist(-1, -1, -1));
    }

    @Test
    public void oneNegativeSide() {
        org.testng.Assert.assertThrows(IllegalArgumentException.class, () -> Triangle.isTriangleExist(-1, 1, 1));
    }

    @Test
    public void allZeroSides() {
        org.testng.Assert.assertThrows(IllegalArgumentException.class, () -> Triangle.isTriangleExist(-0, 0, 0));
    }

    @Test
    public void oneZeroSide() {
        org.testng.Assert.assertThrows(IllegalArgumentException.class, () -> Triangle.isTriangleExist(1, 0, 2));
    }
}
