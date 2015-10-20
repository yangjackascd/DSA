package practicalmockexam;

/* This class implements an ordered tuple 
 * The length of the ordered tuple can be set using the parameter k
 * E.g. an ordered pair is an ordered tuple of length 2
 */
public class Tuple<E> {

    Object[] tup; //We store elements of the tuple in an array

    int k; //This variable indicates the length of the ordered tuple

    public Tuple(int k) {
        tup = new Object[k];
        this.k = k;
    }

    public void set(E[] a) {
        if (a.length == k) {
            tup = a;
        } else {
            System.out.println("Wrong length");
        }
    }

    //Returning a String representing the tuple, 
    //where elements are separated by commas, 
    //and the tuple is surounded by brackets
    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                s = s + (E) tup[0];
            } else {
                s = s + "," + (E) tup[i];
            }
        }
        return s + ")";
    }

    //returning the size of the tuple
    public int size() {
        return k;
    }

    public static void main(String[] args) {
        Tuple<String> tp = new Tuple<>(3);
        String[] st = {"a", "b", "c"};
        tp.set(st);
        System.out.println(tp);
    }
}