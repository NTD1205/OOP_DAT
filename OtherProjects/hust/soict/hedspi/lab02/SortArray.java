package OtherProjects.hust.soict.hedspi.lab02;

import java.util.Scanner;

public class SortArray {
    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Array[%d] = %d\n", i, array[i]);
        }
    }

    static int sumOfArray(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap do dai cua mang: ");
        n = sc.nextInt();
        int[] iArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap phan tu thu %d: ", i);
            iArray[i] = sc.nextInt();
        }
        sortArray(iArray);
        printArray(iArray);

        System.out.println("Tong cac phan tu trong mang = " + sumOfArray(iArray));
        System.out.println("Trung binh cac phan tu trong mang = " + sumOfArray(iArray) / iArray.length);

        sc.close();

    }
}
