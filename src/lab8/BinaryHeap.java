package lab8;

import java.util.ArrayList;


public class BinaryHeap<E extends Comparable<? super E>> {
    
    private ArrayList<E> heap;
    
    public BinaryHeap() {
        heap = new ArrayList<>();
    }
    
    public void enqueue(E item) {
        heap.add(item);
        bubbleUp();
    }
    
    public E dequeue() {
        E item = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        bubbleDown();
        return item;
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    private int kthChild(int index, int k) {
        return 2 * index + k;
    }
    
    private void bubbleUp() {
        int index = heap.size() - 1;
        E item = heap.get(index); 
        while (index > 0 && item.compareTo(heap.get(parent(index))) < 0) {
            heap.set(index, heap.get(parent(index)));
            heap.set(parent(index), item);
            index = parent(index);
        }
    }
    
    private void bubbleDown() {
        int index = 0;
        E item = heap.get(index);
        
        while (kthChild(index, 1) < heap.size()) {
            int childIndex = minChild(index);
            if (heap.get(childIndex).compareTo(heap.get(index)) < 0) {
                heap.set(index, heap.get(childIndex));
                heap.set(childIndex, item);
                index = childIndex;
            } else {
                break;
            }
        }
    }
    
    private int minChild(int index) {
        int bestChildIndex = kthChild(index, 1);
        int position = kthChild(index, 2);
        if (position < heap.size()) {
            if (heap.get(position).compareTo(heap.get(bestChildIndex)) < 0) {
                bestChildIndex = position;
            }
        }       
        return bestChildIndex;
    }
    
    public E peek() {
        return heap.get(0);
    }
    
    @Override
    public String toString() {
        String result = "";
        result = heap.stream().map((item) -> item + " ").reduce(
                result, String::concat);
        return result.trim();
    }
    
    public static void main(String[] args) {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>();
        minHeap.enqueue(3);
        minHeap.enqueue(4);
        minHeap.enqueue(5);
        minHeap.enqueue(6);
        minHeap.enqueue(7);
        minHeap.enqueue(1);
        
        System.out.println(minHeap);
        
        System.out.println(minHeap.dequeue());
        
        System.out.println(minHeap);
    }
}