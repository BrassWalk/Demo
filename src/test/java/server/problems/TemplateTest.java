package server.problems;

import org.junit.Assert;
import org.junit.Test;
import server.problems.Template;

public class TemplateTest {

    @Test
    public void test_plusOne() {
        Assert.assertEquals(11, Template.plusOne(10));
    }
}
