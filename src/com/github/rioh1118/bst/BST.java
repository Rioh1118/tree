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


  private void replaceChild(Node<K, V> parent, Node<K, V> target, Node<K, V> replacement) {
    if (parent == null) {
      // 親が null の場合は root を更新
      this.root = replacement;
    } else if (parent.getLeft() == target) {
      parent.setLeft(replacement);
    } else if (parent.getRight() == target) {
      parent.setRight(replacement);
    }
  }

  @Override
  public boolean delete(K key) {
    // :TODO ここに削除処理を実装してください
    Node<K, V> parent = null;
    Node<K, V> target = this.root;

    while (target != null && !target.getKey().equals(key)) {
      parent = target;
      if (target.getKey().compareTo(key) > 0) {
        target = target.getLeft();
      } else {
        target = target.getRight();
      }
    }

    // 削除対象が見つからなかった場合
    if (target == null) {
      return false;
    }

    // 削除処理
    if (target.getLeft() == null && target.getRight() == null) {
      // ケース1: 葉ノード
      replaceChild(parent, target, null);
    } else if (target.getLeft() == null || target.getRight() == null) {
      // ケース2: 子ノードが1つ
      Node<K, V> child = (target.getLeft() != null) ? target.getLeft() : target.getRight();
      replaceChild(parent, target, child);
    } else {
      // ケース3: 子ノードが2つ
      Node<K, V> successorParent = target;
      Node<K, V> successor = target.getRight();

      // 右部分木の最小値を探す
      while (successor.getLeft() != null) {
        successorParent = successor;
        successor = successor.getLeft();
      }

      // 後継ノードを削除対象ノードに置き換える
      target.setKey(successor.getKey());
      target.setValue(successor.getValue());

      // 後継ノードを削除
      if (successorParent.getLeft() == successor) {
        successorParent.setLeft(successor.getRight());
      } else {
        successorParent.setRight(successor.getRight());
      }
    }

    return true;
  }



  @Override
  public Optional<V> search(K key) {
    // :TODO ここに検索処理を実装してください
    Node<K, V> node = searchNode(this.root, key);

    if (node == null) {
      return Optional.empty();
    }

    return Optional.of(node.getValue());
  }

  private Node<K, V> searchNode(Node<K, V> cur, K key) {

    if (cur == null) {
      return null;
    } else if (cur.getKey().compareTo(key) == 0) {
      return cur;
    } else if (cur.getKey().compareTo(key) > 0) {
      return searchNode(cur.getLeft(), key);
    } else {
      return searchNode(cur.getRight(), key);
    }

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
