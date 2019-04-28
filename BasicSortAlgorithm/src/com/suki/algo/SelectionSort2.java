package com.suki.algo;

// 选择排序的优化
public class SelectionSort2 {

    // 不允许产生任何实例
    private SelectionSort2(){}


    public static void sort(Comparable[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            // 每一轮开始查找时，要保证arr[minIndex] <= arr[maxIndex]
            if(arr[minIndex].compareTo(arr[maxIndex]) == 1){
                swap(arr, minIndex, maxIndex);
            }

            // 在每一轮中同时找到未处理元素的最大值和最小值
            for(int i = left + 1; i < right; i++){
                if(arr[i].compareTo(arr[minIndex]) == -1){  // arr[i]比arr[minIndex]小
                    minIndex = i;
                }else if(arr[i].compareTo(arr[maxIndex]) == 1){  // arr[i]比arr[maxIndex]大
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);  // 将这一轮找到的最小元素放到left处
            swap(arr, right, maxIndex);  // 将这一轮找到的最大元素放到right处

            left++;  // left往右移一个位置
            right--;  // right往左移一个位置
        }
    }


    private static void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 2000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0 , 10000);
        SortTestHelper.testSort("com.suki.algo.SelectionSort2", arr);
    }

}
