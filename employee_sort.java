package com.prateek;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class employee_sort {

    public static void main(String args[]) {

        // traversing via the list of users now
        List<Employee> emp=  Arrays.asList(
                new Employee("E1",10000,"Bengaluru"),
                new Employee("E2",10000,"Bombay"),
                new Employee("E3",12000,"Delhi"),
                new Employee("E4",10000,"Ahemdabad"));


                //Collections.sort(users); // need to implement the comparable interface
        // sort using comparator
        System.out.println("------------By City -------------");
        Collections.sort(emp,new EmployeeSortByCity());
        for (Object u:emp) {
            Employee e = (Employee) u;
            System.out.println(e.id +"---"+e.city+" -- "+e.salary);
        }

        System.out.println("------------By Salary -------------");

        Collections.sort(emp, new EmployeeSortBySalary());

        // convert list to array

        for (Object u:emp) {
            Employee e = (Employee) u;
            System.out.println(e.id +"---"+e.city+" -- "+e.salary);
        }
    }


}

class Employee implements Comparable {
    public int salary;
    public String id;
    public String city;

    public Employee(String id, int salary, String city) {
        this.id = id;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public int compareTo(Object o) {
        Employee user = (Employee) o;

        if (this.salary > user.salary) {
            return 1;
        } else if (this.salary < user.salary) {
            return -1;
        } else {
            return 0;
        }
    }
}

class EmployeeSortByCity implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        Employee e1 =  o1;
        Employee e2 =  o2;

        // first sorting

        // second sorting
        String city1 = e1.city;
        String city2 = e2.city;
//
        return city1.compareTo(city2);
        //return user1.id - user2.id;
    }
}

class EmployeeSortBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        Employee emp1 =  o1;
        Employee emp2 =  o2;


        return Integer.compare(emp2.salary, emp1.salary);
    }
}