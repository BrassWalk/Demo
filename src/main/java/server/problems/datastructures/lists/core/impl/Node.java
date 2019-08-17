package server.problems.datastructures.lists.core.impl;

import server.problems.datastructures.lists.core.IDoubleLinkedNode;
import server.problems.datastructures.lists.core.ILinkedNode;

public class Node implements ILinkedNode, IDoubleLinkedNode {
    private Integer value;
    private Node previous;
    private Node next;

    public Node(final Integer value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Node getPrevious() {
        return previous;
    }

    @Override
    public void setPrevious(final IDoubleLinkedNode previous) {
        this.previous = (Node) previous;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(final ILinkedNode next) {
        this.next = (Node) next;
    }

    @Override
    public void setNext(final IDoubleLinkedNode next) {
        this.next = (Node) next;
    }
}
