package sortingAlgos;

import java.util.Scanner;

public class QuickSort {

    /*
    * Worst Case  -O(n^2)
    * Best Case   -O(nlogn)
    * Average Case-O(nlogn)
    * */

    static void QSort(int arr[],int l,int h){
        int pivot;
        if(l>h){
            return;
        }
        if(h>l){
            pivot=partition(arr,l,h);
            QSort(arr,l,pivot-1);
            QSort(arr,pivot+1,h);
        }
    }
    static int partition(int arr[],int l,int h){
        int left,right;
        int pivot_item=arr[l];
        right=h;
        left=l;
        while(right>left){
            while(arr[left]<=pivot_item){
                left++;
            }
            while(arr[right]>pivot_item){
                right--;
            }
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;

            }

        }
        arr[l]=arr[h];
        arr[right]=pivot_item;
        return right;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.format("Enter %d elements",n);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        QSort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
