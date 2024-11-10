package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    @Test
    public static void positiveNumbers() {
        Assert.assertEquals(Main.factorial(3), 6);
    }
    @Test
    public static void zero() {
        Assert.assertEquals(Main.factorial(0), 1);
    }
    @Test
    public static void negativeNumbers() {
        Assert.assertEquals(Main.factorial(-1), -1);
        Assert.assertEquals(Main.factorial(-10), -1);
    }
}
