package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
public class ArrayList<E extends Comparable<? super E>> extends AbstractList<E> {
    
    private E[] values;
    private int initialCapacity;
    
    public ArrayList(int initialCapacity) {
        values = (E[])new Comparable[initialCapacity];
        this.initialCapacity = initialCapacity;
        count = 0;
    }
    
    public ArrayList() {
        this(10);
    }
    
    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void clear() {
        values = (E[])new Comparable[initialCapacity];
        count = 0;
    }
    
    @Override
    public E remove(int index) {
        E result = get(index);
        count--;
        while (index < count) {
            values[index] = values[index+1];
            index++;
        }
        values[count] = null;
        return result;
    }
    
    @Override
    public void add(int index, E value) {
        ensureCapacity();
        
        for (int i = count; i > index; i--) {
            values[i] = values[i-1];
        }
        
        values[index] = value;
        count++;
    }
    
    @Override
    public int indexOf(E value) {
        int result = 0;
        for (E otherValue : values) {
            if (otherValue.compareTo(value) == 0) {
                return result;
            }
            result++;
        }
        return -1;
    }
    
    @Override
    public E set(int index, E value) {
        E oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    private void ensureCapacity() {
        if (values.length < count + 1) {
            int newLength = values.length;
            newLength *= 2;
            
            E[] newValues = (E[])new Comparable[newLength];
            
            for (int index = 0; index < count; index++) {
                newValues[index] = values[index]; 
            }
            values = newValues;
        }
    }
    
}
