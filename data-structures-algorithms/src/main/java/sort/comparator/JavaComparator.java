package sort.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class JavaComparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    /**
     * 按照Id从小到大排序
     */
    public static class IdAscComparator implements Comparator<Student> {

        /**
         * 返回负数的时候，第一个参数排在前面
         * 返回正数的时候，第二个参数排在前面
         * 返回0的时候，谁在前面无所谓
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return
         */
        @Override
        public int compare(Student o1, Student o2) {
            /**********************
             if(o1.id < o2.id){
             return -1;
             }else if(o2.id < o1.id){
             return 1;
             }else {
             return 0;
             }
             ********************/
            //上面这段代码等同于下面这段
            return o1.id - o2.id;
        }
    }

    /**
     * 按照Id从大到小排序
     */
    public static class IdDescComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            /************************
             if(o1.id > o2.id){
             return -1;
             }else if(o2.id > o1.id){
             return 1;
             }else {
             return 0;
             }
             **************************/
            //上面这段等同于下面这段
            return o2.id - o1.id;
        }
    }

    /**
     * 复合排序，先按照年龄从小到大排序，年龄一样的按照Id从小到大排序
     */
    public static class AgeIdAscComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int i = o1.age - o2.age;
            if (i != 0) {
                return i;
            } else {
                return o1.id - o2.id;
            }
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("A", 2, 22);
        Student s2 = new Student("B", 3, 20);
        Student s3 = new Student("C", 1, 18);
        Student s4 = new Student("D", 4, 18);
        Student[] arr = new Student[]{s1, s2, s3, s4};
        System.out.println("=========按照Id从小到大排序=========");
        Arrays.sort(arr, new IdAscComparator());
        printStudents(arr);
        System.out.println("=========按照Id从大到小排序=========");
        Arrays.sort(arr, new IdDescComparator());
        printStudents(arr);
        System.out.println("=========先按照年龄从小到大排序，年龄一样的按照Id从小到大排序=========");
        Arrays.sort(arr, new AgeIdAscComparator());
        printStudents(arr);
    }

    private static void printStudents(Student[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].id + "  " + arr[i].name + "  " + arr[i].age);
        }
    }
}
