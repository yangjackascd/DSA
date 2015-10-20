package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
public class SinglyLinkedList<E extends Comparable<? super E>> extends AbstractList<E> {
    
    private Node<E> head;
    
    public SinglyLinkedList() {
        head = null;
        count = 0;
    }
    
    @Override
    public int indexOf(E value) {
        Node<E> finger = head;
        int index = 0;
        while (finger != null && finger.value().compareTo(value) != 0) {
            finger = finger.next();
            index++;
        }
        if (finger != null) return index;
        else return -1;
    }
    
    @Override
    public void add(int index, E value) {
        if (index < 0 || index > count) return;
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
        if (index < 0 || index >= count) return null;
        E value;
        if (index == 0) {
            value = head.value();
            head = head.next();
        } else {
            Node<E> previous = head;
            Node<E> finger = head.next();
            while (index > 1) {
                previous = finger;
                finger = finger.next();
                index--;
            }
            value = finger.value();
            previous.setNext(finger.next());
        }
        count--;
        return value;
    }

    @Override
    public void clear() {
        head = null;
        count = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count) return null;
        E value;
        if (index == 0) {
            value = head.value();
        } else {
            Node<E> finger = head.next();
            while (index > 1) {
                finger = finger.next();
                index--;
            }
            value = finger.value();
        }
        return value;
    }

    @Override
    public E set(int index, E value) {
        if (index < 0 || index >= count) return null;
        E otherValue;
        if (index == 0) {
            otherValue = head.value();
            head.setValue(value);
        } else {
            Node<E> finger = head.next();
            while (index > 1) {
                finger = finger.next();
                index--;
            }
            otherValue = finger.value();
            finger.setValue(value);
        }
        return otherValue;
    }
    
    private class Node<E> {
        
        private E value;
        private Node<E> next;
        
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
        
        public Node<E> next() {
            return next;
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
