package com.prateek.concurrentCollections.Threadss;

import javax.xml.soap.Detail;
import java.util.*;

public class ThreadUserAssignment {
    public static void main(String args[]) throws InterruptedException{
        List<List<details>> userList=new ArrayList<>();

        User u1=new User(1,"user1");
        u1.projects.add(new Projects(1,"prj1"));
        u1.projects.add(new Projects(2,"prj2"));

        User u2=new User(2,"User2");
        u2.projects.add(new Projects(2,"prj2"));
        u2.projects.add(new Projects(3,"prj3"));

        List<User> user=Arrays.asList(u1,u2);

        Set<Projects> projectsSet=new TreeSet<>();

//
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for(User u:user){

                    for(Projects p:u.projects) {
                        details d = new details(u.getU_id(),u.getU_name(),p.getP_id());
                        d.project.add(p);
                        List<details> details=new ArrayList<>();
                        details.add(d);
                        userList.add(details);
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(List l:userList){
                    for(Object d:l){
                        System.out.println(((details)d).getU_id()+" "
                                +((details)d).getU_name()+" "
                                +((details)d).getP_id()+" "
                                +((details) d).getProject().toString());
                    }
                }
            }git
        });
        t.start();
        t.join();
        t2.start();
//        for(User u:user){
//
//            for(Projects p:u.projects) {
//                details d = new details(u.getU_id(),u.getU_name(),p.getP_id());
//                d.project.add(p);
//                List<details> details=new ArrayList<>();
//                details.add(d);
//                userList.add(details);
//            }
//        }
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

    public int getU_id() {
        return u_id;
    }

    public String getU_name() {
        return u_name;
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

    public int getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }
}

class details{
    private int u_id,p_id;
    private String u_name;
    private Projects p;
    List<Projects> project=new ArrayList<>();
    public details(int u_id,String u_name,int p_id){
        this.p_id=p_id;
        this.u_name=u_name;
        this.u_id=u_id;
    }
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

    public int getP_id() {
        return p_id;
    }

    public String getU_name() {
        return u_name;
    }

    public int getU_id() {
        return u_id;
    }

    public List<Projects> getProject() {
        return project;
    }
    //    @Override
//    public String toString() {
//        return "{"+"u_id : "+u_id+" u_name :"+u_name+" p_id :"+p_id+"},"+"{"+p.toString()+"}";
//    }
}