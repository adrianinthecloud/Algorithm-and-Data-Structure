package com.osfocus.www.basic.c02;

import java.util.Iterator;

// doubly circular linked list
public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                if (this.data == null) return true;
                return false;
            } else {
                return obj.equals(this.data);
            }
        }

        @Override
        public String toString() {
            return "Node [value=" + data + "]";
        }
    }

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(T elem) {
        initList(elem);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public T peekFirst() {
        return head.data;

    }

    public T peekLast() {
        return tail.data;

    }

    public T removeFirst() {
        T firstVal = head.data;
        removeNode(head);

        return firstVal;
    }

    public T removeLast() {
        T lastVal = tail.data;
        removeNode(tail);

        return lastVal;
    }

    public void addFirst(T elem) {
        if (size == 0) {
            initList(elem);
        } else {
            Node<T> newNode = new Node(elem);
            mutualLink(tail, newNode);
            mutualLink(newNode, head);
            head = newNode;
            size++;
        }
    }

    public void addLast(T elem) {
        if (size == 0) {
            initList(elem);
        } else {
            Node<T> newNode = new Node(elem);
            mutualLink(tail, newNode);
            mutualLink(newNode, head);
            tail = newNode;
            size++;
        }
    }

    private void initList(T elem) {
        head = new Node(elem);
        head.next = head;
        head.prev = head;
        tail = head;
        size++;
    }

    public int indexOf(T elem) {
        if (head.equals(elem)) return 0;
        Node tmpNode = head.next;
        int i = 1;
        while (!tmpNode.equals(elem) && tmpNode != head) {
            i++;
            tmpNode = tmpNode.next;
        }

        if (tmpNode == head) {
            return -1;
        } else {
            return i;
        }
    }

    public void add(T elem) {
        addLast(elem);
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Input argument " + index + " is out of list bound");

        Node<T> curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        T returnVal = curNode.data;
        removeNode(curNode);

        return returnVal;
    }

    public boolean remove(T elem) {
        if (isEmpty()) return false;

        if (size == 1 && head.equals(elem)) {
            clear();
            return true;
        } else if (size > 1) {
            Node curNode = head;
            do {
                if (curNode.equals(elem)) {
                    removeNode(curNode);

                    return true;
                } else {
                    curNode = curNode.next;
                }
            } while (curNode != head);
        }
        return false;
    }

    public void clear() {
        Node<T> curNode = head;
        while (curNode != null) {
            Node<T> next = curNode.next;
            curNode.data = null;
            curNode.prev = null;
            curNode.next = null;
            if (next != head) {
                curNode = next;
            } else {
                break;
            }
        }

        head = tail = null;
        size = 0;
    }

    // Empty this linked list, O(n)
    public void clearX() {
        Node trav = head;
        while (trav != null) {
            Node next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == node) {
            clear();
            return;
        }

        prev.next = next;
        next.prev = prev;

        if (head == node) {
            head = next;
        } else if (tail == node) {
            tail = prev;
        }

        size--;
    }

    // Node from is the prev Node of Node to, while Node to is the next Node of Node from
    public void mutualLink(Node from, Node to) {
        from.next = to;
        to.prev = from;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> curNode = null;
            @Override
            public boolean hasNext() {
                if (curNode == null) {
                    return !isEmpty();
                } else {
                    return curNode.next != head;
                }
            }

            @Override
            public T next() {
                if (curNode == null) {
                    curNode = head;
                } else {
                    curNode = curNode.next;
                }
                return curNode.data;
            }

        };
    }
}
