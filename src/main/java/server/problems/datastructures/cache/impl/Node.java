package server.problems.datastructures.cache.impl;

class Node<E> {
    private final String key;
    private E element;

    Node(final String key, final E element) {
        this.key = key;
        this.element = element;
    }

    public String getKey() {
        return key;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}