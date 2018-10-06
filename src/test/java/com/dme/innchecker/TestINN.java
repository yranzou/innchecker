package com.dme.innchecker;

import org.junit.Assert;
import org.junit.Test;

public class TestINN {
    private INNChecker INNChecker = new INNChecker();

    @Test
    public void validWithoutKPP() {
        Assert.assertEquals("Valid INN test without KPP",
                "3",
                INNChecker.check("7707083893"));
    }

    @Test
    public void valid() {
        Assert.assertEquals("Valid INN test",
                "0",
                INNChecker.check("132808730606"));
    }

    @Test
    public void notRegistered() {
        Assert.assertEquals("Not registered INN test",
                "4",
                INNChecker.check("501805655608"));
    }

    @Test
    public void invalid() {
        Assert.assertEquals("Invalid INN test",
                "5",
                INNChecker.check("501805655607"));
    }

    @Test
    public void invalidSymbolsCount() {
        Assert.assertEquals("Invalid symbols count test",
                "6",
                INNChecker.check("5018"));
    }


}
