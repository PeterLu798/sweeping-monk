package sort.XOR;

public class XOROperation {
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void printOddTimesNun2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        //此时 eor = a ^ b

        //提取出最右的1
        int rightOne = eor & (~eor + 1);
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + "  " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 3, 3, 3, 3, 5, 5, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9};
        printOddTimesNun2(arr);
    }
}
