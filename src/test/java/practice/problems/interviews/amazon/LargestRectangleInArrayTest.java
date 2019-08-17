package practice.problems.interviews.amazon;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleInArrayTest {

    private static final practice.problems.interviews.amazon.LargestRectangleInArray largestRectangleInArray = new practice.problems.interviews.amazon.LargestRectangleInArray();

    @Test
    public void test_getLargestRectangleInArray() {

        final int[] array = {1, 2, 3, 2, 1, 2, 3, 2, 1};
        Assert.assertEquals("[1, 7, 12]", largestRectangleInArray.getLargestRectangle(array).toString());
    }
}
