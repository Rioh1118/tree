package com.github.rioh1118.binary;

import com.github.rioh1118.Tree;
import java.util.Optional;

class Node<K, V> {
  private K key;
  private V value;

  private Node<K, V> left;
  private Node<K, V> right;

  // コンストラクタ
  public Node(K key, V value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  }

  // ゲッタ、 セッタ
  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Node<K, V> getLeft() {
    return left;
  }

  public void setLeft(Node<K, V> left) {
    this.left = left;
  }

  public Node<K, V> getRight() {
    return right;
  }

  public void setRight(Node<K, V> right) {
    this.right = right;
  }
}


public class BinaryTree<K, V> implements Tree<K, V> {
  @Override
  public boolean insert(V value) {
    // :TODO ここに挿入処理を実装してください
    return false;
  }

  @Override
  public boolean delete(K key) {
    // :TODO ここに削除処理を実装してください
    return false;
  }

  @Override
  public Optional<V> search(K key) {
    // :TODO ここに検索処理を実装してください
    return Optional.empty();
  }

  @Override
  public int size() {
    // :TODO ここにサイズ取得処理を実装してください
    return 0;
  }

  @Override
  public boolean isEmpty() {
    // :TODO ここに空かどうか判定する処理を実装してください
    return false;
  }

}
