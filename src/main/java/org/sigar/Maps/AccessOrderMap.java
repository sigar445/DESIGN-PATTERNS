package org.sigar.Maps;
import java.util.HashMap;
//TO DO  - IMPLEMENT BY MYSELF
class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev, next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class AccessOrderMap<K, V> {
    private HashMap<K, Node<K, V>> map;
    private Node<K, V> head, tail;

    public AccessOrderMap() {
        map = new HashMap<>();
        head = new Node<>(null, null); // Dummy head
        tail = new Node<>(null, null); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    private void moveToTail(Node<K, V> node) {
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node<K, V> node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        moveToTail(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToTail(node);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addToTail(newNode);
        }
    }

    public void remove(K key) {
        Node<K, V> node = map.remove(key);
        if (node != null) {
            removeNode(node);
        }
    }
}

