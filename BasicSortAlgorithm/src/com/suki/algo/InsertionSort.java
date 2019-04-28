package com.suki.algo;


// 插入排序
public class InsertionSort {

    // private不允许产生任何实例
    private InsertionSort(){}


    public static void sort(Comparable[] arr){
        // 插入排序的思想：
        // 从左往右每次i指针指向一个元素，该元素是指要插入其左边某个位置的元素
        // j指针一开始和i指针一样指向同一位置，但j指针会往左走；每走一步和j-1指针元素比较
        // 若j指针处的元素值比j-1指针处的元素值小，则交换这两个地方的值
        int n = arr.length;
        for(int i = 0; i < n; i++){
            // 寻找arr[i]合适的插入位置

            // 写法1
//            for(int j = i; j > 0; j--){
//                if(arr[j].compareTo(arr[j-1]) == -1){  // 这里由于判断条件是j>0，所以无需担心越界问题
//                    swap(arr, j, j-1);
//                }else{
//                    break; // 由于插入排序i指针左边都已经排序好了，所以可以break（厉害呀）
//                }
//            }

            // 写法2
//            for(int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) == -1; j--){
//                swap(arr, j, j -1);
//            }

            // 写法3
            // 前面方法缺点：每次出现前面元素比当前元素大时，都会进行一次交换操作有3次复制操作太费时间
            // 现在改成每次出现这种情况的话只进行一次赋值操作
            Comparable e = arr[i];
            int j = i;
            for(; j > 0 && arr[j - 1].compareTo(e) == 1; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }


    // 交换指定数组指定位置的两个值
    public static void swap(Object[] arr, int i, int j){
        if(i < j || i < 0 || j >= arr.length){
            throw new IllegalArgumentException("参数设置错误");
        }

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        int N = 20;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        InsertionSort.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }

}
