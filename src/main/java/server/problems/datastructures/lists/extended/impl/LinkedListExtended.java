package server.problems.datastructures.lists.extended.impl;

import server.problems.datastructures.lists.core.ILinkedNode;
import server.problems.datastructures.lists.core.impl.LinkedList;
import server.problems.datastructures.lists.extended.ILinkedListExtended;

public class LinkedListExtended extends LinkedList implements ILinkedListExtended {

    public LinkedListExtended(final int[] array) {
        super(array);
    }

    @Override
    public void insertIatKthFromEnd(final int k, final int i) {
        ILinkedNode leading = this.getHead();
        ILinkedNode trailing = this.getHead();

        if (this.getHead() == null) {
            throw new RuntimeException("List is empty");
        }

        for (int j = 0; j < k; j++) {
            if (leading.getNext() == null) {
                throw new RuntimeException("Length of linked list less than input k");
            }
            leading = leading.getNext();
        }

        while (leading.getNext() != null) {
            leading = leading.getNext();
            trailing = trailing.getNext();
        }

        insert(trailing, i);
    }
}
