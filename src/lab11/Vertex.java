package lab11;

import java.util.Objects;

public class Vertex<E> {
    
    private final E label;
    
    public Vertex(E label) {
        this.label = label;
    }
    
    public E getLabel() {
        return label;
    }
    
    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(this.label, other.label);
    }
    
    @Override
    public String toString() {
        return "<Vertex: " + label + ">"; 
    }
    
    
    
}
