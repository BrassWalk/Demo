package server.problems.datastructures.lists.extended;

import org.junit.Assert;
import org.junit.Test;
import server.problems.datastructures.lists.extended.impl.LinkedListExtended;

public class LinkedListExtendedTest {

    @Test
    public void test_insertIatKthFromEnd() {
        final int[] array = {1, 2, 3, 4, 5};
        final ILinkedListExtended linkedListProblems = new LinkedListExtended(array);

        linkedListProblems.insertIatKthFromEnd(2, -3);

        Assert.assertEquals("[ 1, 2, 3, -3, 4, 5 ]", linkedListProblems.toString());
    }
}
