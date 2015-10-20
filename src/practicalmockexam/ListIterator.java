package practicalmockexam;

import java.util.Iterator;

//This is an Iterator for a singly linked list
public class ListIterator<E> implements Iterator<E> {

    SinglyLinkedList<E> list;
    Node<E> current;

    public ListIterator(SinglyLinkedList<E> list) {
        this.list = list;
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E value = current.value();
        current = current.next();
        return value;
    }

    @Override
    public void remove() {

    }

}