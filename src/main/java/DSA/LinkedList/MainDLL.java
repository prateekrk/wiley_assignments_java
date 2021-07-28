package DSA.LinkedList;

import java.util.Scanner;

public class MainDLL{
    public static <E extends Number> void main(String args[]  )throws ClassCastException{
        Scanner sc=new Scanner(System.in);
        DoublyLinkedList ddl=new DoublyLinkedList();
        while(true){
            System.out.println("1. Add Element ");
            System.out.println("2. Display List ");
            System.out.println("3. Delete");
            System.out.println("4. Sort");
            System.out.println("5. Exit");
            System.out.println("Enter Choice : ");
            int c=sc.nextInt();
            switch (c){
                case 1: System.out.println("Enter element : ");
                        Number n;
                        if(sc.hasNextInt()) {
                            n = sc.nextInt();
                            ddl.insertNode(n);
                        }
                        else {
                            n=sc.nextDouble();
                            ddl.insertNode(n);
                        }
                        break;
                case 2:
                    ddl.traverse();
                    break;
                case 3:
                    System.out.println("Enter element to be deleted: ");
//                    Number element1=sc.nextInt();
//                    ddl.delete( element1);
                    Object o1=sc.next();
                    ddl.delete((Number) o1);
                    break;
                case 4:
                    ddl.sort();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
