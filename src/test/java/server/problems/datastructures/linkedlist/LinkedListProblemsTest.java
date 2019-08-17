package server.problems.datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import server.problems.datastructures.linkedlist.LinkedListProblems;
import server.problems.datastructures.linkedlist.Node;

public class LinkedListProblemsTest {

    @Test
    public void test_insertIatKthFromEnd() {
        final LinkedListProblems linkedListProblems = new LinkedListProblems();

        final int[] array = {1 , 2 , 3 , 4 , 5};
        final Node linkedList = buildList(array);
        linkedListProblems.insertIatKthFromEnd(linkedList, 2, -3);

        Assert.assertEquals("[ 1, 2, 3, -3, 4, 5 ]", linkedListProblems.toString(linkedList));
    }

    private Node buildList(int[] array) {
        final Node head = new Node(Integer.valueOf(array[0]));
        Node node = head;

        for(int i = 1; i < array.length; i++) {
            node.next = new Node(Integer.valueOf(array[i]));
            node = node.next;
        }

        return head;
    }
}
