package demo.domain.datastore;

import java.util.List;

public interface IInMemoryCache<K, V> {
    void put(final K key, final V value);

    V get(final K key);

    List<V> getAll();

    void print();
}
