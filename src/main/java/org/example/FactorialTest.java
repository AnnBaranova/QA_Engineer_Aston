package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    @Test
    public void positiveNumbers() {
        Assertions.assertEquals(6, Main.factorial(3));
        Assertions.assertEquals(40320, Main.factorial(8));
        Assertions.assertEquals(3628800, Main.factorial(10));
    }
    @Test
    public void zero() {
        Assertions.assertEquals(1, Main.factorial(0));
    }
    @Test
    public void negativeNumbers() {
        Assertions.assertEquals(-1, Main.factorial(-1));
        Assertions.assertEquals(-1, Main.factorial(-10));
    }
}
