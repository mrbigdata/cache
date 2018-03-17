package com.example.code.cache;

/**
 * Provides basic cache functionality
 */
public interface Cache<K,V> {

  /**
   * Inserts a new entry or updates existing entry if the key exists.
   * @param key key of the entry to insert or update.
   * @param value value for the entry to insert or update.
   */
  void put(K key,V value);

  /**
   * Retrieves entry value for the given key.
   * @param key
   * @return value for the given key,
   *         null if key not found.
   */
  V get(K key);

  /**
   * Removes cache entry with the given key
   * @param key key of the entry to be removed. Can't be null.
   * @return value for the removed key.
   *         null if key not found.
   */
  V remove(K key);

  /**
   * removes all cache entries
   */
  void clear();
}
