package practicalmockexam;

import java.util.Iterator;

/* This class implements a Singly Linked List data structure
 * 
 */
public class SinglyLinkedList<E> implements Iterable<E> {

    protected Node<E> head;
    protected int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    // Return an iterator of the list
    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        count = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    // Output a String representation of the linked list
    @Override
    public String toString() {
        String st = "";
        if (head != null) {
            st = "" + head.value();
        }
        Node<E> finger = head;
        while (finger != null) {
            finger = finger.next();
            if (finger != null) {
                st = st + "=>" + finger.value();
            }
        }
        return st;
    }

    // Return the index of the element o if it is contained in the linked list
    // otherwise return -1
    public int indexOf(E o) {
        Node<E> finger = head;
        int index = 0;
        while (finger != null && !finger.value().equals(o)) {
            finger = finger.next();
            index = index + 1;
        }
        if (finger != null) {
            return index;
        } else {
            return -1;
        }
    }

    //Add an element o at position i
    public void add(int i, E o) {
        if (i < 0 || i > count) {
            return;
        }
        Node<E> previous = head;
        if (i == 0) {
            head = new Node<>(o, previous);
        } else {
            Node<E> finger = previous.next();
            while (i > 1) {
                previous = finger;
                finger = finger.next();
                i--;
            }
            Node<E> current = new Node<>(o, finger);
            previous.setNext(current);
        }
        count++;
    }

    //Add an element o at the end of the list
    public void add(E o) {
        add(count, o);
    }

    //Remove the element at position i, given that the list contains this position
    public E remove(int i) {
        if (i < 0 || i >= count) {
            return null;
        }
        E e;
        if (i == 0) {
            e = head.value();
            head = head.next();
        } else {
            Node<E> previous = head;
            Node<E> finger = head.next();
            while (i > 1) {
                previous = finger;
                finger = finger.next();
                i--;
            }
            e = finger.value();
            previous.setNext(finger.next());
        }
        count--;
        return e;
    }

    //Remove the element o if it is contained in the list
    public E remove(E o) {
        return remove(indexOf(o));
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> s = new SinglyLinkedList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        System.out.println(s);
        System.out.println("index of d is " + s.indexOf("d"));
    }

}