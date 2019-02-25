package sort;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description //todo
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,1,7,5,9,8,2};
        System.out.println(Arrays.toString(sort(arr)));
        System.out.println(Arrays.toString(sort2(arr)));
        System.out.println(Arrays.toString(sort3(arr)));
        System.out.println(Arrays.toString(sort4(arr)));
    }

    /***
     *相邻元素比较，大的放后面，小的放前面，大的继续和后面比较
     **/
    public static int[] sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int x=i+1;x<arr.length;x++){
                if(arr[i]>arr[x]){
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[x];
                    arr[x] = temp;
                }
            }
        }
        return arr;
    }

    /***
     *相邻元素比较，大的放后面，小的放前面，大的继续和后面比较
     **/
    public static int[] sort3(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int x=0;x<arr.length-i-1;x++){
                if(arr[x]>arr[x+1]){
                    int temp;
                    temp = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;
                }
            }
        }
        return arr;
    }

    /***
     *从大向小
     **/
    public static int[] sort4(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int x=0;x<arr.length-i-1;x++){
                if(arr[x]<arr[x+1]){
                    int temp;
                    temp = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;
                }
            }
        }
        return arr;
    }
    /***
     *从大向小
     **/
    public static int[] sort2(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int x=i+1;x<arr.length;x++){
                if(arr[i]<arr[x]){
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[x];
                    arr[x] = temp;
                }
            }
        }
        return arr;
    }

}
