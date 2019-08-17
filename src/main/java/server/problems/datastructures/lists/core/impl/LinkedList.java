package server.problems.datastructures.lists.core.impl;

import server.problems.datastructures.lists.core.ILinkedList;
import server.problems.datastructures.lists.core.ILinkedNode;

import java.util.StringJoiner;

public class LinkedList implements ILinkedList {

    private LinkedNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(final int[] array) {
        if (array.length > 0) {
            this.setHead(new LinkedNode(Integer.valueOf(array[0])));

            LinkedNode currentNode = this.getHead();

            for (int i = 1; i < array.length; i++) {
                currentNode.setNext(new LinkedNode(Integer.valueOf(array[i])));
                currentNode = currentNode.getNext();
            }
        } else {
            this.head = null;
        }
    }

    protected LinkedNode getHead() {
        return head;
    }

    protected void setHead(LinkedNode head) {
        this.head = head;
    }

    @Override
    public String toString() {
        final StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        server.problems.datastructures.lists.core.impl.LinkedNode current = head;

        while (current != null) {
            stringJoiner.add(current.getValue().toString());
            current = current.getNext();
        }

        return stringJoiner.toString();
    }

    @Override
    public void insert(final ILinkedNode linkedNode, final int i) {
        final ILinkedNode nextLinkedNode = linkedNode.getNext();
        final ILinkedNode newLinkedNode = new server.problems.datastructures.lists.core.impl.LinkedNode(i);
        linkedNode.setNext(newLinkedNode);
        newLinkedNode.setNext(nextLinkedNode);
    }
}
