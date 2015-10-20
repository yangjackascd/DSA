/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

/**
 *
 * @author JakeYang
 */
public class insertSort {

    public static void main(String a[]) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};

        int[] arr2 = doInsertionSort(arr1, 7);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(", ");
        }
        

    }
    // n for to the number of the list, if dont have int n , it will sort all once.
    public static int[] doInsertionSort(int[] input, int n) {

        int temp;
        for (int i = 1; i < input.length; i++) {
            if (n <= i) {
                return input;
            }
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }

            }
        }
        return input;
    }

}
