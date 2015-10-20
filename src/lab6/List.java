package lab6;

/**
 *
 * @author mmahmoud
 * @param <E>
 */
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
