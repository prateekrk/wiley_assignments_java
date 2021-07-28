package DSA.LinkedList;

import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList myLinkedList=new LinkedList();
        while(true) {
            System.out.println("1. Add Element ");
            System.out.println("2. Display List ");
            System.out.println("3. Display List ");
            System.out.println("4. Exit");
            System.out.println("Enter Choice : ");
            int choice=sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter element : ");
                    Object element=sc.next();
                    myLinkedList.insertIntoList(element);
                    break;
                case 2:
                    myLinkedList.traverse();
                    break;
                case 3:
                    myLinkedList.reverse();
                    break;
                case 4:
                    System.out.println("Thanks for creating link list");
                    System.exit(0);
            }
            System.out.println("=========================");
        }

    }

}
