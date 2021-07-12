package com.prateek.concurrentCollections.Threadss;

import java.util.*;

public class ThreadUserAssignment {
    public static void main(String args[]){
        List<List<User>> userList=new ArrayList<>();

        User u1=new User(1,"user1");
        u1.projects.add(new Projects(1,"prj1"));
        u1.projects.add(new Projects(2,"prj2"));

        User u2=new User(2,"User2");
        u2.projects.add(new Projects(2,"prj2"));
        u2.projects.add(new Projects(3,"prj3"));

        List<User> user=Arrays.asList(u1,u2);

        Set<Projects> projectsSet=new TreeSet<>();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator i=user.iterator();
                while(i.hasNext()){
                    userList.add((new ArrayList<>().add(i.next())));
                }
            }
        });
        System.out.println(userList.get(0).size());

    }
}
class User{
    private int u_id;
    private String u_name;
    List<Projects> projects=new ArrayList<>();

    public User(int id,String name){
        this.u_id=id;
        this.u_name=name;
    }

    @Override
    public String toString() {
        return "u_id : "+this.u_id+", p_name : "+u_name;
    }
}
class Projects implements Comparable<Projects>{
    private int p_id;
    private String p_name;
    public Projects(int id,String name){
        this.p_id=id;
        this.p_name=name;
    }

    @Override
    public String  toString() {
        return "p_id : "+this.p_id+", p_name : "+p_name;
    }

    @Override
    public int compareTo(Projects p) {
        return this.p_id-p.p_id;
    }
}

class details{
    private int u_id,p_id;
    private String u_name;
    private Projects p;

    public void setP(Projects p) {
        this.p = p;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "{"+"u_id : "+u_id+" u_name :"+u_name+" p_id :"+p_id+"},"+"{"+p.toString()+"}";
    }
}