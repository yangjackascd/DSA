package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
public class DoublyLinkedList<E extends Comparable<? super E>> extends AbstractList<E> {
    
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void clear() {
        head = null;
        tail = null;
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
    public E get(int index) {
        if (index >= size()) return null;
        Node<E> finger = head;
        while (index > 0) {
            finger = finger.next();
            index--;
        }
        return finger.value();
    }

    @Override
    public void add(int index, E value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == count) { 
            addLast(value);
        } else {
            Node<E> before = null;
            Node<E> after = head;
            while (index > 0)
            {
                before = after;
                after = after.next();
                index--;
            }
            Node<E> current =
                new Node(value, after,before);
            count++;
            before.setNext(current);
            after.setPrevious(current);
        }
    }

    @Override
    public E remove(int index) {
        if (index == 0) return removeFirst();
        else if (index == size()-1) return removeLast();
        Node<E> previous = null;
        Node<E> finger = head;
        while (index > 0) {
            previous = finger;
            finger = finger.next();
            index--;
        }
        previous.setNext(finger.next());
        finger.next().setPrevious(previous);
        count--;
        return finger.value();
    }

    @Override
    public E set(int index, E value) {
        if (index >= size()) return null;
        Node<E> finger = head;
        while (index > 0)
        {
            finger = finger.next();
            index--;
        }
        E result = finger.value();
        finger.setValue(value);
        return result;
    }
    
    public void addFirst(E value) {
        head = new Node(value, head, null);
        if (tail == null) tail = head;
        count++;
    }
    
    public void addLast(Object value) {
        tail = new Node(value, null, tail);
        if (head == null) head = tail;
        count++;
    }
    
    public E removeFirst() {
        Node<E> temp = head;
        head = head.next();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        temp.setNext(null);
        count--;
        return temp.value();
    }
    
     public E removeLast() {
        Node<E> temp = tail;
        tail = tail.previous();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        count--;
        return temp.value();
    }
    
    private class Node<E> {
        
        private E value;
        private Node<E> next;
        private Node<E> previous;
        
        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
        
        public Node<E> next() {
            return next;
        }
        
        public Node<E> previous() {
            return previous;
        }
        
        public E value() {
            return value;
        }
        
        public void setNext(Node<E> next) {
            this.next = next;
        }
        
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
        
        public void setValue(E value) {
            this.value = value;
        }
        
    }
    
}
