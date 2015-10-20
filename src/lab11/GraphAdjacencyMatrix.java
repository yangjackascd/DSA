package lab11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphAdjacencyMatrix<E> implements Graph<E> {
    
    private final int size;
    
    private final Edge<E> adjacencyMatrix[][];
    
    private final Map<E, DictionaryEntry<E>> dictionary;
    
    private List<Integer> freeList;
    
    private final boolean isDirected;
    
    public GraphAdjacencyMatrix(int size, boolean isDirected) {
        this.size = size;
        this.isDirected = isDirected;
        adjacencyMatrix = new Edge[size][size];
        dictionary = new HashMap<>();
        freeList = new LinkedList<>();
        for (int row = 0; row < size; row++) {
            freeList.add(row);
        }
    }

    @Override
    public boolean addVertex(E label) {
        if (dictionary.containsKey(label)) {
            return false;
        }
        int row = freeList.remove(0);
        Vertex<E> vertex = new Vertex(label);
        dictionary.put(label, new DictionaryEntry(vertex, row));
        return true;
    }

    @Override
    public boolean addEdge(E vertex1Label, E vertex2Label) {
        if (dictionary.containsKey(vertex1Label) && 
                dictionary.containsKey(vertex2Label)) {
            DictionaryEntry<E> vertex1DictionaryEntry = dictionary.get(vertex1Label);
            DictionaryEntry<E> vertex2DictionaryEntry = dictionary.get(vertex2Label);
            
            Edge<E> edge = new Edge(vertex1Label, vertex2Label);
            
            adjacencyMatrix[vertex1DictionaryEntry.getIndex()]
                    [vertex2DictionaryEntry.getIndex()] = edge;
            
            if (!isDirected) {
                edge = new Edge(vertex2Label, vertex1Label);
                adjacencyMatrix[vertex2DictionaryEntry.getIndex()]
                    [vertex1DictionaryEntry.getIndex()] = edge;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(E label) {
        DictionaryEntry<E> vertexDictionaryEntry = dictionary.get(label);
        if (vertexDictionaryEntry == null) {
            return false;
        }
        
        int index = vertexDictionaryEntry.getIndex();
        for (int row=0; row < size; row++) {
            adjacencyMatrix[row][index] = null;
            adjacencyMatrix[index][row] = null;
        }
        freeList.add(index);
        return true;
    }

    @Override
    public boolean removeEdge(E vertex1Label, E vertex2Label) {
        if (dictionary.containsKey(vertex1Label)
                && dictionary.containsKey(vertex2Label)) {

            DictionaryEntry<E> vertex1DictionaryEntry = dictionary.get(vertex1Label);
            DictionaryEntry<E> vertex2DictionaryEntry = dictionary.get(vertex2Label);
            
            adjacencyMatrix[vertex1DictionaryEntry.getIndex()]
                    [vertex2DictionaryEntry.getIndex()] = null;
            
            if (!isDirected) {
                adjacencyMatrix[vertex2DictionaryEntry.getIndex()]
                    [vertex1DictionaryEntry.getIndex()] = null;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsVertex(E label) {
        return dictionary.containsKey(label);
    }

    @Override
    public boolean containsEdge(E vertex1Label, E vertex2Label) {
        if (!dictionary.containsKey(vertex1Label) ||
                !dictionary.containsKey(vertex2Label)) {
            return false;
        }
        
        DictionaryEntry<E> vertex1DictionaryEntry = dictionary.get(vertex1Label);
        DictionaryEntry<E> vertex2DictionaryEntry = dictionary.get(vertex2Label);
        
        return (adjacencyMatrix[vertex1DictionaryEntry.getIndex()]
                [vertex2DictionaryEntry.getIndex()] != null);
    }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public Iterator<E> vertexes() {
        return dictionary.keySet().iterator();
    }

    @Override
    public Iterator<E> neighbours(E label) {
        DictionaryEntry<E> vertexDictionaryEntry = dictionary.get(label);
        if (vertexDictionaryEntry != null) {
            List<E> list = new LinkedList<>();
            for (int row = 0; row < size; row++) {
                Edge<E> edge =
                        adjacencyMatrix[vertexDictionaryEntry.getIndex()][row];
                if (edge != null) {
                    list.add(edge.getFromVertexLabel());
                }
            }
            return list.iterator();
        }
        return null;
    }

    @Override
    public void clear() {
        dictionary.clear();
        freeList = new LinkedList<>();
        for (int row = 0; row < size; row++) {
            freeList.add(row);
            for (int col = 0; col < size; col++) {
                adjacencyMatrix[row][col] = null;
            }
        }
        
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E key : dictionary.keySet()) {
            stringBuilder.append(dictionary.get(key).getIndex());
            stringBuilder.append(":");
            stringBuilder.append(dictionary.get(key).getVertex().getLabel());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        
        stringBuilder.append("   ");
        for (int row = 0; row < size; row++) {
            stringBuilder.append(" ");
            stringBuilder.append(row);
            stringBuilder.append(" ");
        }
        stringBuilder.append("\n");
        
        for (int row = 0; row < size; row++) {
            stringBuilder.append(" ");
            stringBuilder.append(row);
            stringBuilder.append(" ");
            for (int col = 0; col < size; col++) {
                if (adjacencyMatrix[row][col] == null) {
                    stringBuilder.append("[ ]");
                } else {
                    stringBuilder.append("[*]");
                }
            }
            stringBuilder.append("\n");
        }
        
        return stringBuilder.toString();
    }
    
    private static class DictionaryEntry<E> {
        
        private final Vertex<E> vertex;
        private final int index;
        
        public DictionaryEntry(Vertex<E> vertex, int index) {
            this.vertex = vertex;
            this.index = index;
        }

        public Vertex<E> getVertex() {
            return vertex;
        }
        
        public int getIndex() {
            return index;
        }
        
    }
    
    public static void main(String[] args) {
        GraphAdjacencyMatrix<String> graph = new GraphAdjacencyMatrix(10, true);
        
        graph.addVertex("New York");
        graph.addVertex("Paris");
        graph.addVertex("London");
        graph.addVertex("Sydney");
        graph.addVertex("Dubia");
        graph.addVertex("Buenos Aires");
        
        graph.addEdge("New York", "London");
        graph.addEdge("London", "Paris");
        
        System.out.println(graph);
        
        graph.removeEdge("New York", "London");
        
        System.out.println(graph);
    }
}
