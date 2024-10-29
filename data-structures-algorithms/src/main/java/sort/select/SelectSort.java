package sort.select;

public class SelectSort {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { // i —— N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i~N-1上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 2, 6, 8, 9, 10, 33, 22, 3, 5, 6, 3, 8, 3, 3, 8};
        selectSort(arr);
        for (int cur : arr) {
            System.out.print(cur);
            System.out.print("  ");

        }
    }
}
