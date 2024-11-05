package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {
    @Test
    public static void baseTest() {
        Assert.assertEquals(Main.factorial(3), 6);
        Assert.assertEquals(Main.factorial(0), 1);
        Assert.assertEquals(Main.factorial(-1), -1);
        Assert.assertEquals(Main.factorial(-10), -1);
    }
}
