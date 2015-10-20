package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
public class CircularLinkedList <E extends Comparable<? super E>> extends AbstractList<E> {
    
    private Node<E> tail;
    
    public CircularLinkedList() {
        tail = null;
        count = 0;
    }

    @Override
    public void clear() {
                count = 0;
        tail = null;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        Node<E> finger = tail.next();
        while (finger != null && finger.value().compareTo(value) != 0) {
            if (finger == tail) {
                finger = null;
            } else {
                finger = finger.next();
            }
            index++;
        }

        if (finger == null) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size()) {
            return null;
        }
        Node<E> finger = tail.next();
        while (index > 0) {
            finger = finger.next();
            index--;
        }
        return finger.value();
    }

    @Override
    public void add(int index, E value) {
        if (index == 0) addFirst(value);
        else if (index == size()) addLast(value);
        else {
            Node previous = tail;
            Node next = tail.next();
            while (index > 0)
            {
                previous = next;
                next = next.next();
                index--;
            }
            Node current = new Node(value,next);
            count++;
            previous.setNext(current);
        }
    }

    @Override
    public E remove(int index) {
        if (index == 0) return removeFirst();
        if (index == size()-1) return removeLast();
        Node<E> previous = tail;
        Node<E> finger = tail.next();
        while (index > 0)
        {
            index--;
            previous = finger;
            finger = finger.next();
        }
        previous.setNext(finger.next());
        count--;
        return finger.value();
    }

    @Override
    public E set(int index, E value) {
        if (index >= size()) {
            return null;
        }
        Node<E> finger = tail.next();
        while (index > 0) {
            finger = finger.next();
            index--;
        }
        E result = finger.value();
        finger.setValue(value);
        return result;
    }
    
    public void addFirst(E value) {
        Node<E> temp = new Node<>(value, null);
        if (tail == null) { 
            tail = temp;
            tail.setNext(tail);
        } else { 
            temp.setNext(tail.next());
            tail.setNext(temp);
        }
        count++;
    }
    
    public void addLast(E value) {
        addFirst(value);
        tail = tail.next();
    }
    
    public E removeLast() {
        Node<E> finger = tail;
        while (finger.next() != tail) {
            finger = finger.next();
        }
        Node<E> temp = tail;
        if (finger == tail) {
            tail = null;
        } else {
            finger.setNext(tail.next());
            tail = finger;
        }
        count--;
        return temp.value();
    }
    
      public E removeFirst() {
        Node<E> temp = tail.next();
        if (tail == tail.next()) {
            tail = null;
        } else {
            tail.setNext(temp.next());
            temp.setNext(null);
        }
        count--;
        return temp.value();
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
