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
public abstract class AbstractList< E extends Comparable<? super E>> implements List<E> {

    protected int count;

    public E remove(E value) {
        int index = indexOf(value);
        if (index != -1) {
            return remove(index);

        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E value) {
        return -1 != indexOf(value);
    }

    @Override
    public int size() {
        return count;
    }
}
