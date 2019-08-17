package practice.problems;

import org.junit.Assert;
import org.junit.Test;
import server.problems.SolutionTemplate;

public class SolutionTemplateTest {

    @Test
    public void test_LRUCache() {
        System.out.print("TEST INPUT: 10\n");

        int result = SolutionTemplate.plusOne(10);

        System.out.print("TEST INPUT: " + result + "\n");

        Assert.assertEquals(11, result);
    }
}
