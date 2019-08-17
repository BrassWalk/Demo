package server.problems.datastructures.lists.core.impl;

import server.problems.datastructures.lists.core.IDoubleLinkedNode;
import server.problems.datastructures.lists.core.ILinkedNode;

public class LinkedNode implements ILinkedNode, IDoubleLinkedNode {
    private Integer value;
    private LinkedNode previous;
    private LinkedNode next;

    public LinkedNode(final Integer value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public LinkedNode getPrevious() {
        return previous;
    }

    @Override
    public void setPrevious(final IDoubleLinkedNode previous) {
        this.previous = (LinkedNode) previous;
    }

    @Override
    public LinkedNode getNext() {
        return next;
    }

    @Override
    public void setNext(final ILinkedNode next) {
        this.next = (LinkedNode) next;
    }

    @Override
    public void setNext(final IDoubleLinkedNode next) {
        this.next = (LinkedNode) next;
    }
}
