import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 12, 1, 3132, 1, 134, 13};
        Array array = new Array();

        System.out.print("Bubble sort: ");
        System.out.println(array.bubbleSort(new Array(arr)));

        System.out.print("Cocktail sort: ");
        System.out.println(array.cocktailSort(new Array(arr)));

        System.out.print("Selection sort: ");
        System.out.println(array.selectionSort(new Array(arr)));

        System.out.print("Insertion sort: ");
        System.out.println(array.insertionSort(new Array(arr)));

        System.out.print("Shall sort: ");
        System.out.println(array.shellSort(new Array(arr)));

        System.out.print("Merge sort: ");
        array.mergeSort(new Array(arr));
        System.out.println(Arrays.toString(arr).replaceAll("[,\\[\\]]", ""));
    }
}