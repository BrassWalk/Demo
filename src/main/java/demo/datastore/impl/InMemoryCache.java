package demo.datastore.impl;

import demo.datastore.IInMemoryCache;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCache<K, V> implements IInMemoryCache<K, V> {

    private final Map<K, Node<K, V>> cacheMap;
    private final LinkedList<Node<K, V>> cacheQueue;
    private final int capacity;


    public InMemoryCache(final int capacity) {
        this.cacheMap = new HashMap<>();
        this.cacheQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public void put(final K key, final V value) {
        final Node<K, V> cacheNode = this.cacheMap.get(key);

        if (cacheNode != null) {
            cacheNode.setValue(value);
            resetQueuePosition(cacheNode);
        } else {
            if (this.cacheMap.size() == this.capacity) {
                this.evict();
            }

            final Node<K, V> newNode = new Node(key, value);
            this.cacheMap.put(key, newNode);
            this.cacheQueue.addLast(newNode);
        }
    }

    @Override
    public V get(final K key) {
        final Node<K, V> Node = this.cacheMap.get(key);

        if (Node != null) {
            resetQueuePosition(Node);
        }

        return Node == null ? null : Node.getValue();
    }

    @Override
    public List<V> getAll() {
        return this.cacheQueue.stream().map(node -> {
            return node.getValue();
        }).collect(Collectors.toList());
    }

    @Override
    public void print() {
        final StringJoiner stringJoiner = new StringJoiner(", ", "Cache: [ ", " ]");
        final Iterator iterator = this.cacheQueue.iterator();

        while (iterator.hasNext()) {
            Node<K, V> node = (Node<K, V>) iterator.next();
            stringJoiner.add("(" + node.getKey() + ", " + node.getValue().toString() + ")");
        }

        System.out.println(stringJoiner.toString());
    }

    private void resetQueuePosition(final Node<K, V> node) {
        this.cacheQueue.remove(node);
        this.cacheQueue.addLast(node);
    }

    private void evict() {
        this.cacheMap.remove(this.cacheQueue.getFirst().getKey());
        this.cacheQueue.removeFirst();
    }
}
