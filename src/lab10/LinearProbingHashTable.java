package lab10;

import java.util.LinkedList;
import java.util.Queue;

public class LinearProbingHashTable<E, T> {

    private static final int INIT_CAPACITY = 4;

    private int n; 
    private int m; 
    private HashObject<E, T>[] hashTable;

    public LinearProbingHashTable() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        m = capacity;
        hashTable = new HashObject[m];
    }
	
	    public T get(HashObject<E, T> hashObject) {
        for (int i = hash(hashObject); hashTable[i] != null; i = (i + 1) % m) {
            if (hashTable[i].getKey() == hashObject) {
                return hashTable[i].getValue();
            }
        }
        return null;
    }
	
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(HashObject<E, T> hashObject) {
        return get(hashObject) != null;
    }

    private int hash(HashObject<E, T> hashObject) {
        return (hashObject.hashCode()) % m;
    }

    private int hash(E key) {
        return (HashObject.hashCode(key)) % m;
    }

    private void resize(int capacity) {
        LinearProbingHashTable<E, T> temp = new LinearProbingHashTable<>(capacity);
        for (int i = 0; i < m; i++) {
            if (hashTable[i] != null) {
                temp.put(hashTable[i]);
            }
        }

        hashTable = temp.hashTable;
        n = temp.m;

    }

    public void put(HashObject<E, T> hashObject) {
        if (hashObject.getValue() == null) {
            delete(hashObject);
            return;
        }

        if (n >= n / 2) resize(2 * n);
        
        int i;
        for (i = hash(hashObject); hashTable[i] != null; i = (i + 1) % m) {
            if (hashTable[i].equals(hashObject)) {
                hashTable[i].setValue(hashObject.getValue());
                return;
            }
        }
        hashTable[i] = hashObject;
        n++;
    }

    public T get(E key) {
        for (int i = hash(key); hashTable[i] != null; i = (i + 1) % m) {
            if (hashTable[i].getKey() == key) {
                return hashTable[i].getValue();
            }
        }
        return null;
    }



    public void delete(HashObject<E, T> hashObject) {
        if (!contains(hashObject)) {
            return;
        }

        int i = hash(hashObject);
        while (!hashObject.equals(hashTable[i])) {
            i = (i + 1) % m;
        }

        hashTable[i] = null;

        i = (i + 1) % m;
        while (hashTable[i] != null) {
            E keyToRehash = hashTable[i].getKey();
            T valueToRehash = hashTable[i].getValue();
            hashTable[i] = null;
            n--;
            put(new HashObject(keyToRehash, valueToRehash));
            i = (i + 1) % m;
        }

        n--;

        if (n > 0 && n <= m / 8) {
            resize(m / 2);
        }
    }

    public Iterable<E> keys() {
        Queue<E> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (hashTable[i] != null) {
                queue.offer(hashTable[i].getKey());
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<String, Integer> table = new LinearProbingHashTable<>();
        
        HashObject <String, Integer> hashObject1 = new HashObject<>("Bob", 1);
        HashObject <String, Integer> hashObject2 = new HashObject<>("Jack", 2);
        HashObject <String, Integer> hashObject3 = new HashObject<>("Jill", 3);
        HashObject <String, Integer> hashObject4 = new HashObject<>("Jim", 4);
        HashObject <String, Integer> hashObject5 = new HashObject<>("Joe", 5);
        
        table.put(hashObject1);
        table.put(hashObject2);
        table.put(hashObject3);
        table.put(hashObject4);
        table.put(hashObject5);
        
       
                
        
    }


}
