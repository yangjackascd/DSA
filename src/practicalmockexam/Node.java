package practicalmockexam;

//Node class used for Singly Linked List
public class Node<E> {

    protected E data;
    protected Node<E> nextElement;

    public Node(E v, Node<E> next) {
        data = v;
        nextElement = next;
    }

    public Node<E> next() {
        return nextElement;
    }

    public void setNext(Node<E> next) {
        nextElement = next;
    }

    public E value() {
        return data;
    }

    public void setValue(E value) {
        data = value;
    }

}