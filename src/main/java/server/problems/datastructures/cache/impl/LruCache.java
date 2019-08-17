package server.problems.datastructures.cache.impl;

import server.problems.datastructures.cache.ILruCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringJoiner;

public class LruCache<E> implements ILruCache<E> {

    private final Map<String, Node<E>> cacheMap;
    private final LinkedList<Node<E>> cacheQueue;
    private final int capacity;

    public LruCache(final int capacity) {
        this.cacheMap = new HashMap<>(capacity);
        this.cacheQueue = new LinkedList();
        this.capacity = capacity;
    }

    public void print() {
        final StringJoiner stringJoiner = new StringJoiner(", ", "Cache: [ ", " ]");
        final Iterator iterator = this.cacheQueue.iterator();

        while (iterator.hasNext()) {
            Node<E> node = (Node<E>) iterator.next();
            stringJoiner.add("(" + node.getKey() + ", " + node.getElement().toString() + ")");
        }

        System.out.println(stringJoiner.toString());
    }

    public void put(
            final String key,
            final E element) {
        final Node<E> cacheNode = this.cacheMap.get(key);


        if (cacheNode != null) {
            cacheNode.setElement(element);
            resetQueuePosition(cacheNode);
        } else {
            if (this.cacheMap.size() == this.capacity) {
                this.evict();
            }

            final Node<E> newNode = new Node(key, element);
            this.cacheMap.put(key, newNode);
            this.cacheQueue.addLast(newNode);
        }
    }

    public E get(final String key) {
        final Node<E> Node = this.cacheMap.get(key);

        if (Node != null) {
            resetQueuePosition(Node);
        }

        return Node == null ? null : Node.getElement();
    }

    private void resetQueuePosition(final Node<E> node) {
        this.cacheQueue.remove(node);
        this.cacheQueue.addLast(node);
    }

    private void evict() {
        this.cacheMap.remove(this.cacheQueue.getFirst().getKey());
        this.cacheQueue.removeFirst();
    }
}
