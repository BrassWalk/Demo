package server.problems.datastructures.lists.core;

public interface ILinkedNode {

    Integer getValue();

    ILinkedNode getNext();

    void setNext(final ILinkedNode next);
}
