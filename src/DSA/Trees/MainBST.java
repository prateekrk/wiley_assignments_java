package DSA.Trees;

import java.util.Scanner;

public class MainBST {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        while(true) {
            System.out.println("1. Add Element");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. PostOrder Traversal");
            System.out.println("4. PreOrder Traversal");
            System.out.println("5. Max value");
            System.out.println("6. Min value");
            System.out.println("7. Exit");
            System.out.println("Enter Choice : ");
            int choice=sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter Element : ");
                    int element=sc.nextInt();
                    binarySearchTree.insert(element);
                    break;
                case 2:
                    binarySearchTree.inorder();
                    break;
                case 3:
                    binarySearchTree.postOrder();
                    break;
                case 4:
                    binarySearchTree.preOrder();
                    break;
                case 5:
                    System.out.println(binarySearchTree.maxElement());
                    break;
                case 6:
                    System.out.println(binarySearchTree.minElement());
                    break;
                case 7:
                    System.out.println("Thanks for creating Binary Search Tree");
                    System.exit(0);
            }
        }

    }
}
