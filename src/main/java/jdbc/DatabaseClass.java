package jdbc;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class DatabaseClass {
    public static void main(String args[]){
        Connection connection=null;
        Scanner sc=new Scanner(System.in);


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee1", "root", "admin69");
            Statement statement = connection.createStatement();


//            while (true) {
//                System.out.println("1. Insert\n2.Display\n3.Delete\n4.Exit");
//                int c = sc.nextInt();
//                switch (c) {
//                    case 1:
//                    case 2:while (resultSet.next()) {
//                        int id = resultSet.getInt("EMPLOYEE_ID");
//                        String name = resultSet.getString("F_NAME");
//                        String lname = resultSet.getString("LNAME");
//                        System.out.println(id + "     " + name + "      " + lname);
//                    }
//                    break;
//
//                    case 3:
//                        System.out.println("Enter ID");
//                        int id=sc.nextInt();
//                        PreparedStatement preps = connection.prepareStatement("Delete from EMPLOYEES where EMPLOYEE_ID=?");
//                        preps.setInt(1,id);
//                        int rows=preps.executeUpdate();
//                        if (rows > 0)
//                            System.out.println("Employee deleted");
//                        else
//                            System.out.println("Employee delete Failed");
//                        break;
//                    case 4:
//                        System.exit(0);
//
//
//
//
//                }
//            }
            PreparedStatement preps = connection.prepareStatement("Update EMPLOYEES set salary=salary+(0.1*salary) EMPLOYEE_ID=?");
            int n = sc.nextInt();
            preps.setInt(1, n);
            int rows = preps.executeUpdate();
            if (rows > 0)
                System.out.println("Successful");
            else
                System.out.println("Unsuccessful");
            ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEES");
            while (resultSet.next()) {
                int id = resultSet.getInt("EMPLOYEE_ID");
                String name = resultSet.getString("F_NAME");
                String lname = resultSet.getString("LNAME");
                System.out.println(id + "     " + name + "      " + lname);
            }
        }
        catch (ClassNotFoundException|SQLException s){
            s.printStackTrace();
        }
        finally {
            try {
                //4. close the connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
