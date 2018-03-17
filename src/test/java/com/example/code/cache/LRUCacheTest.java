package com.example.code.cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void testPutGet(){
    LRUCache<Integer, String> cache = new LRUCache<>(5);
    cache.put(1, "1");
    assertEquals("1", cache.get(1));
  }

  @Test
  public void testOldestEvicted(){
    LRUCache<Integer, String> cache = new LRUCache<>(2);
    cache.put(1, "1");
    assertEquals("1", cache.get(1));
    cache.put(2, "2");
    assertEquals("2", cache.get(2));
    cache.put(3, "3");
    assertEquals(null, cache.get(1));
  }

  @Test(expected = NullPointerException.class)
  public void putNullKey(){
    LRUCache<Integer, String> cache = new LRUCache<>(2);
    cache.put(null, "");
  }

  @Test(expected = NullPointerException.class)
  public void putNullValue(){
    LRUCache<Integer, String> cache = new LRUCache<>(2);
    cache.put(1, null);
  }

  @Test(expected = NullPointerException.class)
  public void getByNullKey(){
    LRUCache<Integer, String> cache = new LRUCache<>(2);
    cache.get(null);
  }
}
