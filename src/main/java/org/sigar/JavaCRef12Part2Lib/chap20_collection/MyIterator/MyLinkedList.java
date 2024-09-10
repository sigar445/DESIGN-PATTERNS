package org.sigar.JavaCRef12Part2Lib.chap20_collection.MyIterator;

import java.util.ListIterator;
import java.util.NoSuchElementException;
//NOT MINE - AI GEN try to write your own
public class MyLinkedList<T> {
    // Define the Node class
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and tail of the linked list
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor for the Linked List
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) { // List is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Get size of the list
    public int size() {
        return size;
    }

    // Other list methods (like remove, clear, etc.) can be added here

    // Create an iterator for this list
    public ListIterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    // Inner class to implement the iterator
    private class MyLinkedListIterator implements ListIterator<T> {
        private Node<T> current = head; // Points to the current node
        private Node<T> lastReturned = null; // Points to the last returned node
        private int nextIndex = 0; // Index of the next node

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) { // If at the end, start from the tail
                current = tail;
            } else {
                current = current.prev;
            }
            lastReturned = current;
            nextIndex--;
            return current.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<T> nextNode = lastReturned.next;
            Node<T> prevNode = lastReturned.prev;

            if (prevNode == null) { // Node is the head
                head = nextNode;
            } else {
                prevNode.next = nextNode;
                lastReturned.prev = null;
            }

            if (nextNode == null) { // Node is the tail
                tail = prevNode;
            } else {
                nextNode.prev = prevNode;
                lastReturned.next = null;
            }

            size--;
            nextIndex--;
            lastReturned = null; // Reset lastReturned after removal
        }

        @Override
        public void set(T e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.data = e;
        }

        @Override
        public void add(T e) {
            Node<T> newNode = new Node<>(e);
            Node<T> prevNode = (current == null) ? tail : current.prev;

            newNode.next = current;
            newNode.prev = prevNode;

            if (prevNode == null) {
                head = newNode;
            } else {
                prevNode.next = newNode;
            }

            if (current == null) {
                tail = newNode;
            } else {
                current.prev = newNode;
            }

            size++;
            nextIndex++;
            lastReturned = null; // Reset lastReturned after addition
        }
    }
}

