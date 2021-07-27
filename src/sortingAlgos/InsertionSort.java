package sortingAlgos;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class InsertionSort {

    /*
    * Worst case  -O(n^2)
    * Best  case  -O(n^2)
    * Average case-O(n^2)
    * */

     static void ISort(int arr[],int n){
        int q,j;
        for(int i=2;i<=n;i++){
            q=arr[i-1];
            j=i-2;
            while(j>=0 && arr[j]>q){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=q;
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
        ISort(arr,n);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
