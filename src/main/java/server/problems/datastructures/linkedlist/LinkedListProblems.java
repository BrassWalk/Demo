package server.problems.datastructures.linkedlist;

import java.util.StringJoiner;

public class LinkedListProblems {

    // List can be arbitrarily large. Don't want stack overflow or integer overflow.
    public void insertIatKthFromEnd(
            final Node head,
            final int k,
            final int i) {
        Node leading = head;
        Node trailing = head;

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        for (int j = 0; j < k; j++) {
            if (leading.next == null) {
                throw new RuntimeException("Length of linked list less than input k");
            }
            leading = leading.next;
        }

        while (leading.next != null) {
            leading = leading.next;
            trailing = trailing.next;
        }

        insert(trailing, i);
    }

    public String toString(final Node head) {
        final StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        Node current = head;

        while(current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }

        return stringJoiner.toString();
    }

    private void insert(
            final Node node,
            final int i) {
        final Node nextNode = node.next;
        final Node newNode = new Node(i);
        node.next = newNode;
        newNode.next = nextNode;
    }

}
