package com.prateek;

import java.util.*;

class User {
    private String name,id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
class Employee1 extends User{
    int salary;
    Address address;
    Project project;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Address getAddress() {
        return address;
    }

    public Project getProject() {
        return project;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
class Address{
    String city,zipcode;
    Address(String city,String zipcode){
        this.city=city;
        this.zipcode=zipcode;
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
class Project{
    int projectId,budget;
    String projectName;
    Project(int projectId,int budget,String projectName){
        this.projectId=projectId;
        this.budget=budget;
        this.projectName=projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getBudget() {
        return budget;
    }
}

public class budget {
    public static void main(String args[]){

        List<User> user=new ArrayList();
        List<Employee1> emp=new ArrayList();
        Project p=new Project(1023,1000,"KIAS");

        //employee1
        Employee1 e1=new Employee1();
        e1.setId("e1");
        e1.setName("xyz");
        e1.setSalary(500);
        e1.setProject(p);



        //employee2
        Employee1 e2=new Employee1();
        e2.setId("e2");
        e2.setName("abc");
        e2.setSalary(400);
        e2.setProject(p);



        //employee3
        Employee1 e3=new Employee1();
        e3.setId("e3");
        e3.setName("pqr");
        e3.setSalary(300);
        e3.setProject(p);

        user.add(e1);
        user.add(e2);
        user.add(e3);


        for(User u: user){
            if(u instanceof Employee1){
                Employee1 e=(Employee1) u;
                emp.add(e);
            }
        }
        Collections.sort(emp,new SortBySalary());

        //project
        int i=p.getBudget();

        int resource=0;
        Iterator iterator=emp.iterator();
        while(resource<=i){
            while(iterator.hasNext()){
                Employee1 e=(Employee1) iterator.next();
                if(e.getSalary()<=i){
                    resource=e.getSalary();
                    i-=resource;
                    System.out.println(e.getId()+" "+e.getProject().getProjectId());
                }

            }
        }

    }
}
