package com.suki.algo;


// 冒泡排序的实现
public class BubbleSort {

    // 不允许产生任何实例
    private BubbleSort(){}


    public static void sort(Comparable[] arr){
        int n = arr.length;
        boolean swapped = false;

        do{
            swapped = false;
            for(int i = 1; i < n; i++){  // 注意是从i=1开始，因为每次和其前一个元素相比
                if(arr[i - 1].compareTo(arr[i]) == 1){  // 每次交换相邻的两个元素，若当前元素比其上一个元素小的话则交换
                    swap(arr, i-1, i);
                    swapped = true;
                }
            }

            n--;  // 扫描一次for循环后会把最大的数移到最后面，所以n--
        }while (swapped);
    }


    private static void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("com.suki.algo.BubbleSort", arr);
    }

}
