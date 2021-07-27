package sortingAlgos;

import java.util.Scanner;

public class SelectionSort {
    static void Ssort(int[] arr){
        int min,n=arr.length;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            for(int z=0;z<n;z++){
                System.out.print(arr[z]+" ");
            }
            System.out.println();
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
        Ssort(arr);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
