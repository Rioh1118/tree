package com.github.rioh1118;

import java.util.Optional;

public interface Tree<K, V> {

  boolean insert(V value);

  boolean delete(K key);

  Optional<V> search(K key);

  int size();

  boolean isEmpty();

}
