package practice.problems.datastructures.impl;

import org.junit.Assert;
import org.junit.Test;

// Least recently used cache requirements:
// 1. evict the least recently used item.
// 2. map keys to values
// 3. Can put, get, and initialize with max capacity. When full, evict LRU item.

public class LRUCacheTest {

    @Test
    public void test_LRUCache_putAndget() {
        final String key = "test-key";
        final String value = "test-value";

        final LRUCache<String> cache = new LRUCache(10);

        cache.put(key, value);

        final String getValue = cache.get(key);

        Assert.assertNotNull(getValue);
        Assert.assertEquals(value, getValue);
    }

    @Test
    public void test_LRUCache_noValueOnget() {
        final String key = "test-key";
        final String value = "test-value";

        final LRUCache<String> cache = new LRUCache(10);

        cache.put(key + "-no-match", value);

        final String getValue = cache.get(key);
        Assert.assertNull(getValue);
    }

    @Test
    public void test_LRUCache_evictLeastRecentlyUsedItem() {
        final LRUCache<String> cache = new LRUCache(3);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                cache.put("key-2", "value-2");
                cache.print();
            }

            if (i % 3 == 0) {
                cache.put("key-3", "value-3");
                cache.print();
            }

            if (i % 4 == 0) {
                cache.put("key-4", "value-4");
                cache.print();
            }

            if (i % 5 == 0) {
                cache.put("key-5", "value-5");
                cache.print();
            }
        }

        Assert.assertNotNull(cache.get("key-2"));
        Assert.assertNotNull(cache.get("key-3"));
        Assert.assertNotNull(cache.get("key-4"));
        Assert.assertNull(cache.get("key-5"));
    }
}
