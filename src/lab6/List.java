/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author JakeYang
 */
//public class List<  E extends Comparable<? super E>> {
//
//    public int size();
//
//    public boolean isEmpty();
//
//    public void clear();
//
//    public boolean contains(E value);
//
//    public int indexOf(E value);
//
//    public E get(int index);
//
//    public void add(int index, E value);
//
//    public E remove(E value);
//
//    public E remove(int index);
//
//    public e set(int index, E value);
//}
public interface List<E extends Comparable<? super E>> {
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
   
    public boolean contains(E value);
    
    public int indexOf(E value);
    
    public E get(int index);
    
    public void add(int index, E value);
    
    public E remove(E value);
    
    public E remove(int index);
    
    public E set(int index, E value);
}