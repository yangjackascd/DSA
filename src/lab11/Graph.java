package lab11;

import java.util.Iterator;

public interface Graph<E> {
    
    public boolean addVertex(E label);
    
    public boolean addEdge(E vertex1Label, E vertex2Label);
    
    public boolean removeVertex(E label);
    
    public boolean removeEdge(E vertex1Label, E vertex2Label);
    
    public boolean containsVertex(E label);
    
    public boolean containsEdge(E vertex1Label, E vertex2Label);
    
    public int size();
    
    public Iterator<E> vertexes();
    
    public Iterator<E> neighbours(E label);
    
    public void clear();
    
    public boolean isEmpty();
    
    public boolean isDirected();
    
}
