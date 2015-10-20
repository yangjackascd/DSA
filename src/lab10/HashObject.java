
package lab10;

import java.util.Objects;


public class HashObject<E, T> {
    private final E key;
    private T value;
    
    public HashObject(E key, T value) {
        this.key = key;
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
	
    public E getKey() {
        return key;
    }


    public void setValue(T value) {
        this.value = value;
    }

    
    
    
    public int hashCode() {
        int hash = 0;
        for(int i = 0; i< getKey().toString().length(); i++) {
            hash = (hash + getKey().toString().charAt(i));
        }
        return hash;
    }
	
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HashObject<?, ?> other = (HashObject<?, ?>) obj;
        return Objects.equals(this.key, other.key);
    }
    
    public static<E> int hashCode(E key) {
        int hash = 0;
        for(int i = 0; i< key.toString().length(); i++) {
            hash = (hash + key.toString().charAt(i));
        }
        return hash;
    }
}
