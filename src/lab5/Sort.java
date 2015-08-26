package lab5;

import java.util.Random;

public class Sort<E extends Comparable<? super E>> {

    private E[] data;

    public Sort(E[] data) {
        this.data = data;
    }

    public void quickSort() {
        quickSortRecursive(0, data.length - 1);
    }

    private void quickSortRecursive(int left, int right) {
        int pivot;
        if (left >= right) {
            return;
        }
        pivot = partition(left, right);
        quickSortRecursive(left, pivot - 1);
        quickSortRecursive(pivot + 1, right);
    }

    private int partition(int left, int right) {
        while (true) {
            while (left < right && data[left].compareTo(data[right]) < 0) {
                right--;
            }
            if (left < right) {
                swap(left++, right);
            } else {
                return right;
            }
            while (left < right && data[left].compareTo(data[right]) < 0) {
                left++;
            }
            if (left < right) {
                swap(left, right--);
            } else {
                return right;
            }
        }
    }

    private void swap(int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            students[i] = new Student();
            students[i].firstName = "A" + random.nextInt();
            students[i].lastName = "B" + random.nextInt();
            students[i].studentID = random.nextInt(100);
        }
        Sort<Student> sort = new Sort(students);
        sort.quickSort();
        for(Student student:students){
            System.out.println(student);
        }
    }
}
