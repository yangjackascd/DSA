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
public class ArrayList< E extends Comparable<? super E>> extends AbstractList<E> {

    private E[] values;
    private int initialCapacity;

    private ArrayList(int initialCapacity) {
        values = (E[]) new Comparable[initialCapacity];
        this.initialCapacity = initialCapacity;
        count = 0;

    }

    public ArrayList() {
        this(10);
    }

    public E get(int index) {
        return values[index];
    }

    @Override
    public void clear() {
        values = (E[]) new Comparable[initialCapacity];
        count = 0;
    }

    @Override
    public E remove(int index) {
        E result = get(index);
        count--;

        while (index < count) {
            values[index] = values[index + 1];
            index++;
        }
        values[count] = null;
        return result;
    }

    private void ensureCapacity() {
        if (values.length < count + 1) {
            int newLength = values.length * 2;
            E[] newValues = (E[]) new Comparable[newLength];
            for (int i = 0; i < count; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
    }

    @Override
    public int indexOf(E value) {
        int result = 0;
        for (E otherValues : values) {
            if (otherValues.compareTo(value) == 0) {
                return result;
            }
            result++;
        }
        return -1;// indcate is not in the array
    }

    @Override
    public void add(int index, E value) {
        ensureCapacity();
        for (int i = count; i < index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = value;
        count++;
    }

    @Override
    public E set(int index, E value) {
        if (index < count) {
            E oldValue = values[index];
            values[index] = value;
            return oldValue;
        }
        return null;
    }
}
