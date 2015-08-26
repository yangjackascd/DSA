/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author JakeYang
 * @param <E>
 */
public class SinglyLinkedList< E extends Comparable<? super E>> extends AbstractList<E> {

    private Node<E> head;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > count) {
            return;
        }
        Node<E> previous = head;
        if (index == 0) {
            head = new Node<>(value, previous);
        } else {
            Node<E> finger = previous.next();
            while (index > 1) {
                previous = finger;
                finger = finger.next();
                index--;
            }
            Node<E> current = new Node<E>(value, finger);
            previous.setNext(current);
        }
        count++;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node<E> {

        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node<E> next() {
            return next();
        }

        public E value() {
            return value;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

}
