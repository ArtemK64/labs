import java.util.Arrays;

public class Array {
    public int[] a;

    public Array(int[] a) {
        this.a = a;
    }

    public Array() {}

    public int getElement(int i) {
        if (checkArray(i)) {
            return a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void setElement(int i, int value) {
        if (checkArray(i)) {
            a[i] = value;
        }
    }

    public int getSize() {
        return a.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: a) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(a, array.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    public boolean checkArray(int i) {
        return i >= 0 && i <= a.length - 1;
    }

    public Array bubbleSort(Array array) {
        boolean isSorted = true;
        while (isSorted) {
            isSorted = false;
            for (int i = 0; i < array.getSize() - 1; i++) {
                if (array.getElement(i) > array.getElement(i + 1)) {
                    isSorted = true;
                    swap(i, i + 1, array);
                }
            }
        }
        return array;
    }

    public static void swap(int i, int j, Array array) {
        int temp = array.getElement(i);
        array.setElement(i, array.getElement(j));
        array.setElement(j, temp);
    }

    public Array cocktailSort(Array array) {
        boolean isSorted = true;
        int start = 0;
        int end = array.getSize();

        while (isSorted) {
            isSorted = false;
            for (int i = start; i < end - 1; i++) {
                if (array.getElement(i) > array.getElement(i + 1)) {
                    isSorted = true;
                    swap(i, i + 1, array);
                }
            }
            if (!isSorted) {
                break;
            }
            isSorted = false;
            end -= 1;

            for (int i = end - 1; i >= start; i--) {
                if (array.getElement(i) > array.getElement(i + 1)) {
                    isSorted = true;
                    swap(i, i + 1, array);
                }
            }
            start += 1;
        }
        return array;
    }

    public Array selectionSort(Array array) {
        for (int i = 0; i < array.getSize() - 1; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < array.getSize(); j++) {
                if (array.getElement(j) < array.getElement(minIndex)) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, array);
        }
        return array;
    }

    public Array insertionSort(Array array) {
        for (int i = 1; i < array.getSize(); i++) {
            int value = array.getElement(i);
            int j = i - 1;

            while (j >= 0 && array.getElement(j) > value) {
                array.setElement(j + 1, array.getElement(j));
                j--;
            }
            array.setElement(j + 1, value);
        }
        return array;
    }

    public Array shellSort(Array array) {
        int n = array.getSize();
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i++) {
                int temp = array.getElement(i);
                int j;
                for (j = i; j >= interval && array.getElement(j - interval) > temp; j -= interval) {
                    array.setElement(j, array.getElement(j - interval));
                }
                array.setElement(j, temp);
            }
        }
        return array;
    }

    public void mergeSort(Array array) {
        int n = array.getSize();

        if (array.getSize() < 2) {
            return;
        }

        int middleIndex = n / 2;
        int[] left = new int[middleIndex];
        int[] right = new int[n - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            left[i] = array.getElement(i);
        }
        for (int i = middleIndex; i < n; i++) {
            right[i - middleIndex] = array.getElement(i);
        }

        mergeSort(new Array(left));
        mergeSort(new Array(right));

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array.setElement(k++, left[i++]);
            }
            else {
                array.setElement(k++, right[j++]);
            }
        }
        while (i < left.length) {
            array.setElement(k++, left[i++]);
        }
        while (j < right.length) {
            array.setElement(k++, right[j++]);
        }
    }
}