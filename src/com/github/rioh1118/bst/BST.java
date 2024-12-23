package com.github.rioh1118.bst;

import com.github.rioh1118.Tree;
import java.util.Optional;

public class Bst<K extends Comparable<K>, V> implements Tree<K, V> {
  private Node<K, V> root;

  public Bst() {
    this.root = null;
  }

  public Bst(K key, V value) {
    this.root = new Node<>(key, value);
  }

  @Override
  public boolean insert(K key, V value) {
    // :TODO ここに挿入処理を実装してください
    try {
      if (this.root == null) {
        root = new Node<>(key, value);
      }
      // 挿入するノードが根ノードよりも小さい場合
      else if (this.root.getKey().compareTo(key) > 0) {
        if (this.root.getLeft() == null) {
          this.root.setLeft(new Node<>(key, value));
        }
        insertNode(this.root.getLeft(), key, value);
      }
      // 挿入するノードが根ノードよりも大きい場合
      else if (this.root.getKey().compareTo(key) < 0) {
        if (this.root.getRight() == null) {
          this.root.setRight(new Node<>(key, value));
        }
        insertNode(this.root.getRight(), key, value);
      } else {
        throw new Error("Key is already exists.");
      }

      return true;
    } catch (Error e) {
      return false;
    }
  }

  // insertメソッドの補助メソッド
  private void insertNode(Node<K, V> cur, K key, V value) throws Error {
    // 挿入するノードが現在のノードよりも小さい場合
    if (cur.getKey().compareTo(key) > 0) {
      if (cur.getLeft() == null) {
        cur.setLeft(new Node<>(key, value));
      } else {
        insertNode(cur.getLeft(), key, value);
      }
    }
    // 挿入するノードが現在のノードよりも大きい場合
    else if (cur.getKey().compareTo(key) < 0) {
      if (cur.getRight() == null) {
        cur.setRight(new Node<>(key, value));
      } else {
        insertNode(cur.getRight(), key, value);
      }
    }
    // 挿入するノードが現在のノードと同じ場合
    else {
      throw new Error("Key is already exists.");
    }
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

  // 二分探索木を表示する
  public void printTree() {
    printSubtree(root, 0);
  }

  // 再帰的に部分木を表示する (内部用)
  private void printSubtree(Node<K, V> node, int depth) {
    if (node == null) {
      return;
    }

    // 右部分木を処理
    printSubtree(node.getRight(), depth + 1);

    // インデントを調整して現在のノードを表示
    System.out.println("  ".repeat(depth) + node.getKey() + ": " + node.getValue());

    // 左部分木を処理
    printSubtree(node.getLeft(), depth + 1);
  }

}
