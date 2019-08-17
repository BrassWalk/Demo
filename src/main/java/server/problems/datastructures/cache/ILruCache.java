package server.problems.datastructures.cache;

// Least recently used cache requirements:
// 1. evict the least recently used item.
// 2. map keys to values
// 3. Can insert, retrieve, and initialize with max size. When full, evict LRU item.

// Cache - linear memory, approx 2N.
public interface ILruCache<E> extends ICache<E> {

    void print();

    void put(final String key, final E element);

    E get(final String key);
}
