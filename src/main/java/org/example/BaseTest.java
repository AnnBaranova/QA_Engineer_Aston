package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseTest {
    @Test
    public void baseTest() {
        Assertions.assertEquals(Main.factorial(3), 6);
        Assertions.assertEquals(Main.factorial(0), 1);
        Assertions.assertEquals(Main.factorial(-1), -1);
        Assertions.assertEquals(Main.factorial(-10), -1);
    }
}
