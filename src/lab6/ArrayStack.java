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
public class ArrayStack<E extends Comparable<? super E>> extends ArrayList<E> implements Stack<E> {

    public ArrayStack() {
        super();
    }
    
    @Override
    public void push(E value) {
        add(size(), value);
    }

    @Override
    public E pop() {
        return remove(size() - 1);
    }

    @Override
    public E peek() {
        return get(size() - 1);
    }


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
    }
    
}
