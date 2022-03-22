package com.bbva.pzic.pockets.util.orika.util;

public interface Cache<K extends Object, V> {
    
    void cache(K key, V value);
    
    V get(Object key);
    
    boolean containsKey(Object key);
}
