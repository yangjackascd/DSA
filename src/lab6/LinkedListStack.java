/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
public class LinkedListStack<E extends Comparable<? super E>> extends CircularLinkedList<E> implements Stack<E> {

    public LinkedListStack() {
        super();
    }
    
    @Override
    public void push(E value) {
        addFirst(value);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E peek() {
        return get(0);
    }
    
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    
}
