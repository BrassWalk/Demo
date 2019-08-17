package server.problems.datastructures.impl;

// Least recently used cache requirements:
// 1. evict the least recently used item.
// 2. map keys to values
// 3. Can insert, retrieve, and initialize with max size. When full, evict LRU item.

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringJoiner;

class Node<E> {
    final String key;
    E element;

    Node(final String key, final E element) {
        this.key = key;
        this.element = element;
    }
}

public class LRUCache<E> {

    // Cache - linear memory, approx 2N.
    private final Map<String, Node<E>> cacheMap;
    private final LinkedList<Node<E>> cacheQueue;
    private final int capacity;

    public LRUCache(final int capacity) {
        this.cacheMap = new HashMap<>(capacity);
        this.cacheQueue = new LinkedList();
        this.capacity = capacity;
    }

    // put() - constant time
    // 1. If Node exists in cache, update element and reset it's queue position
    // 2. If Node does not exist in cache, check if cache is full.
    //      A. If cache is full, eject first Node in queue from cache.
    // 3. Add new Node to cache and end of list
    public void put(
            final String key,
            final E element) {
        final Node<E> cacheNode = this.cacheMap.get(key);


        if (cacheNode != null) {
            cacheNode.element = element;
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

    // get() - constant time
    // 1. if Node exists in cache, reset it's queue position
    // 2. if Node exists in cache, return Node's element, else return null
    public E get(final String key) {
        final Node<E> Node = this.cacheMap.get(key);

        if (Node != null) {
            resetQueuePosition(Node);
        }

        return Node == null ? null : Node.element;
    }

    public void print() {
        final StringJoiner stringJoiner = new StringJoiner(", ", "Cache: [ ", " ]");
        final Iterator iterator = this.cacheQueue.iterator();

        while(iterator.hasNext()) {
            Node<E> node = (Node<E>) iterator.next();
            stringJoiner.add("(" + node.key + ", " + node.element.toString() + ")");
        }

        System.out.println(stringJoiner.toString());
    }

    private void resetQueuePosition(final Node<E> node) {
        this.cacheQueue.remove(node);
        this.cacheQueue.addLast(node);
    }

    private void evict() {
        this.cacheMap.remove(this.cacheQueue.getFirst().key);
        this.cacheQueue.removeFirst();
    }
}
