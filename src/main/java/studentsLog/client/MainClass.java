package studentsLog.client;

import studentsLog.presentation.StudentPresentation;
import studentsLog.presentation.StudentPresentationImpl;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        StudentPresentation stdPresentation=new StudentPresentationImpl();
        Scanner scanner=new Scanner(System.in);
        while(true) {
            stdPresentation.showMenu();
            System.out.println("Enter choice : ");
            int choice=scanner.nextInt();
            stdPresentation.performMenu(choice);

        }

    }
}
