package server.problems.datastructures.lists.core;

public interface IDoubleLinkedNode extends ILinkedNode {

    IDoubleLinkedNode getNext();

    void setNext(final IDoubleLinkedNode next);

    IDoubleLinkedNode getPrevious();

    void setPrevious(final IDoubleLinkedNode previous);
}
