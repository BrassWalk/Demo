package server.problems.datastructures.cache;

public interface ICache<E> {

    void print();

    void put(final String key, final E element);

    E get(final String key);
}
