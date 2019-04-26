package com.suki.selectionSort;

// 基于compareTo接口的选择排序
public class SelectionSortBaseComparable {

    // 不允许产生任何实例
    private SelectionSortBaseComparable(){

    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j].compareTo(arr[i]) == -1){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        // 测试Integer
        Integer[] a = {10, 9, 8, 7, 6, 5};
        SelectionSortBaseComparable.sort(a);
        for (Integer temp: a) {
            System.out.print(temp + "\t");
        }
        System.out.println();


        // 测试Double
        Double[] b = {4.4, 1.1, 2.2, 9.9};
        SelectionSortBaseComparable.sort(b);
        for(Double temp : b){
            System.out.print(temp + "\t");
        }
        System.out.println();

        // 测试自定义类
        Student[] c = new Student[4];
        c[0] = new Student("D", 90);
        c[1] = new Student("C", 100);
        c[2] = new Student("B", 95);
        c[3] = new Student("A", 95);
        SelectionSortBaseComparable.sort(c);
        for(Student temp : c){
            System.out.print(temp + "\t");
        }
        System.out.println();


        // 测试算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("com.suki.selectionSort.SelectionSortBaseComparable", arr);
    }

}
