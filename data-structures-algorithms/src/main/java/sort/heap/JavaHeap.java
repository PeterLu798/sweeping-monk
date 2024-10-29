package sort.heap;

import java.util.PriorityQueue;

public class JavaHeap {
    /**
     * 已知一个几乎有序的数组，几乎有序是指，如果吧数组排好顺序的话，每个元素移动的距离不超过k，并且k相对于数组来说比较小。
     * 请选择一个合适的排序算法针对这个数据进行排序
     *
     * @param arr
     * @param k
     */
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //第一个for循环是将数组0——1位置排好序。Math.min(arr.length, k)是为了防止k值过大，用户胡乱输入
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        //此时index = k+1，第二个for循环的作用是将 k+1——arr.length-1上的数排好序，同时将0——N（N一定小于arr.length）上已经排好序的数据放回到数组中
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        //将剩余的排好序的数字继续放回到数组中
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        //默认是小根堆，add、poll的时间复杂度都是logN级别（包含了扩容的时间复杂度）
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        heap.add(8);
//        heap.add(6);
//        heap.add(3);
//        heap.add(9);
//        heap.add(2);
//        heap.add(1);
//        heap.add(5);
//        heap.add(6);
//        while (!heap.isEmpty()) {
//            System.out.println(heap.poll());
//        }
        int[] arr = {3, 1, 2, 4, 6, 5, 8, 7, 6, 9, 10, 11};
        sortedArrDistanceLessK(arr, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
