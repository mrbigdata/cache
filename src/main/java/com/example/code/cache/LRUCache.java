package com.example.code.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class LRUCache<K, V> implements Cache<K, V>{

  private static final class LRUHashMap<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    LRUHashMap(int capacity){
      super(capacity);
      this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry arg0) {
      return size() > capacity - 1;
    }
  }

  private final Map<K, V> entries;
  private final int capacity;

  public LRUCache(final int capacity){
    this.entries = new LRUHashMap<K, V>(capacity);
    this.capacity = capacity;
  }

  @Override
  public void put(K key, V value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    entries.put(key, value);
  }

  @Override
  public V get(K key) {
    Objects.requireNonNull(key);
    V value = null;
    if(entries.containsKey(key)){
      value = entries.remove(key);
      entries.put(key, value);
    }
    return value;
  }

  @Override
  public V remove(K key) {
    return entries.remove(key);
  }

  @Override
  public void clear() {
    entries.clear();
  }
}
