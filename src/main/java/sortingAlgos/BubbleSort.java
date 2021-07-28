package sortingAlgos;

import java.util.Scanner;

public class BubbleSort {
/*
* Worst case          - O(n^2)
* Avg case            - O(n^2)
* Best case(modified) - O(n)
* */
    static void BSort(int arr[]){
        int n=arr.length;
        //iterate through whole array
        for(int p=0;p<n-1;p++){
            for(int i=p+1;i<n;i++){
                if(arr[p]>arr[i]){
                    //swap element if prev element is > next element
                    int temp=arr[p];
                    arr[p]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }



    static void BSortModified(int arr[]){
        int n=arr.length;
        boolean swap=true;
        //iterate through whole array
        for(int p=0;p<n-1 && swap;p++){
            swap=false;
            for(int i=p+1;i<n;i++){
                if(arr[p]>arr[i]){
                    //swap element if prev element is > next element
                    int temp=arr[p];
                    arr[p]=arr[i];
                    arr[i]=temp;
                    swap=true;
                }
            }
        }
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
        BSortModified(arr);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
