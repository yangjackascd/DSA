package lab11;

import java.util.Objects;

public class Edge<E> {
    
    private final E fromVertexLabel;
    private final E toVertexLabel;
    
    public Edge(E fromVertexLabel, E toVertexLabel) {
        this.fromVertexLabel = fromVertexLabel;
        this.toVertexLabel = toVertexLabel;
    }
    
    @Override
    public int hashCode() {
        return getFromVertexLabel().hashCode() - getToVertexLabel().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge<?> other = (Edge<?>) obj;
        return ((getFromVertexLabel().equals(other.getFromVertexLabel())) &&
                (getToVertexLabel().equals(other.getToVertexLabel())));
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<Edge: ");
        stringBuilder.append(getFromVertexLabel());
        stringBuilder.append(" -> ");
        stringBuilder.append(getToVertexLabel());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public E getFromVertexLabel() {
        return fromVertexLabel;
    }

    public E getToVertexLabel() {
        return toVertexLabel;
    }
    
}
