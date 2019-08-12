package com.dirkarnez;

import com.alex.ChineseNumberBuilder;
import com.alex.Scenario;
import org.junit.Assert;
import org.junit.Test;

public class ChineseNumberTests {
    @Test
    public void test1() {
        Assert.assertEquals("二千零七", new ChineseNumberBuilder(Scenario.ModernNumber).build("2007"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("九億七千萬零二", new ChineseNumberBuilder(Scenario.ModernNumber).build("970000002"));
    }
}