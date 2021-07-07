package com.prateek.budget;
class Employee1 extends User{
    String eid,ename;
    int salary;
    Address address;
    Project project;
    Employee1(User u){
        super(u.getName(),u.getId());
    }

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
    public String toString(){
        return this.eid+" "+this.salary+" "+this.project.getProjectId();

    }
}
