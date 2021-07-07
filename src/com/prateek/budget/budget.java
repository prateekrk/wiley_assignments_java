package com.prateek.budget;

import com.prateek.*;
import com.sun.java.swing.plaf.windows.WindowsTreeUI;

import java.util.*;
import java.util.stream.Collectors;

public class budget {
    public static void main(String args[]){

        List<User> user=new ArrayList();

        Project p=new Project(1023,1000,"KIAS");

        //employee1
        User u1=new User("e1","1");
        User u2=new User("e1","1");
        User u3=new User("e1","1");

        Employee1 e1=new Employee1(u1);

        e1.setSalary(500);
        e1.setProject(p);



        //employee2
        Employee1 e2=new Employee1(u2);
        e2.setSalary(400);
        e2.setProject(p);



        //employee3
        Employee1 e3=new Employee1(u3);
        e3.setSalary(300);
        e3.setProject(p);

        user.add(e1);
        user.add(e2);
        user.add(e3);


        List<Employee1> emp=user.stream()
                .filter(u->u instanceof Employee1).map(Employee1::new)
                .collect(Collectors.toList());
        System.out.println(emp.get(1).getName());
//        for(User u: user){
//            if(u instanceof Employee1){
//                Employee1 e=(Employee1) u;
//                emp.add(e);
//            }
//        }
//
//        //project
//        int i=p.getBudget();
//        int resource=0;
//
//        Iterator iterator=emp.iterator();
//        while(resource<=i){
//            while(iterator.hasNext()){
//                Employee1 e=(Employee1) iterator.next();
//                if(e.getSalary()<=i){
//                    resource=e.getSalary();
//                    i-=resource;
//                    System.out.println(e.getId()+" "+e.getProject().getProjectId());
//                }
//
//
//            }
//    }

    }
}






class SortBySalary implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        Employee1 e1=(Employee1) o1;
        Employee1 e2=(Employee1) o2;
        return Integer.compare(e2.salary, e1.salary);
    }


}