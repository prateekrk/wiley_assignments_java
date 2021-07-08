package com.prateek.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class UserSet {
    public static void main(String args[]){

        System.out.println("-------------------------Case 1-------------------------");
        Set<Type>s=new TreeSet(new SortType1());
        s.add(new Type(new User(1,"Adam")));
        s.add(new Type(new User(2,"User2")));
        s.add(new Type(1));
        s.add(new Type(2));
        s.add(new Type("Hello"));
        s.add(new Type("hi"));
        s.forEach(t->System.out.println(t.toString()));

        System.out.println("\n-------------------------Case 2-------------------------");

        Set<Type>s1=new TreeSet(new SortType2());
        s1.add(new Type(new User(1,"Adam")));
        s1.add(new Type(new User(2,"User2")));
        s1.add(new Type(1));
        s1.add(new Type(2));
        s1.add(new Type("Hello"));
        s1.add(new Type("hi"));
        s1.forEach(t->System.out.println(t.toString()));

        System.out.println("\n-------------------------Case 3-------------------------");

        Set<Type>s3=new TreeSet(new SortType3());
        s3.add(new Type(new User(1,"Adam")));
        s3.add(new Type(new User(2,"User2")));
        s3.add(new Type(1));
        s3.add(new Type(2));
        s3.add(new Type("Hello"));
        s3.add(new Type("hi"));
        s3.forEach(t->System.out.println(t.toString()));

    }
}
class Type  {
    Object o;

    public Type(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {

        return String.valueOf(this.o);
    }
}

class User{
    private int user_id;
    private String user_name;
    public User(int id,String name){
        this.user_id=id;
        this.user_name=name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    @Override
    public String toString(){
        return "{"+getUser_id()+","+getUser_name()+"}";
    }
}

class SortType1 implements Comparator<Type>{


    @Override
    public int compare(Type o1, Type o2) {

        if(o1.o instanceof Integer){
            if(o2.o instanceof  Integer){
                int i=(int) o1.o;
                int j=(int) o2.o;
                return i-j;
            }
            else if(o2.o instanceof String){
                return -1;
            }
            else if(o2.o instanceof User){
                return -1;
            }
            return 0;
        }
        else if(o1.o instanceof  User){
            if(o2.o instanceof User){
            User u1=(User) o1.o;
            User u2=(User) o2.o;
            return u1.getUser_id()-u2.getUser_id();
        }
            else if(o2.o instanceof Integer){
                return 1;
            }
            else if(o2.o instanceof  String){
                    return -1;
            }
            return 0;
        }
        if(o1.o instanceof String){
            if(o2.o instanceof String){
                return o1.o.toString().compareTo(o2.o.toString());
            }
            else if(o2.o instanceof Integer||o2.o instanceof User){
                return 1;
            }
            return 0;
        }

        return 0;
    }
}

class SortType2 implements  Comparator<Type> {

    @Override
    public int compare(Type o1, Type o2) {
        if (o1.o instanceof Integer) {
            if (o2.o instanceof Integer) {
                int i = (int) o1.o;
                int j = (int) o2.o;
                return i - j;
            } else if (o2.o instanceof String) {
                return 1;
            } else if (o2.o instanceof User) {
                return 1;
            }
            return 0;
        } else if (o1.o instanceof User) {
            if (o2.o instanceof User) {
                User u1 = (User) o1.o;
                User u2 = (User) o2.o;
                return u1.getUser_id() - u2.getUser_id();
            } else if (o2.o instanceof Integer) {
                return 1;
            } else if (o2.o instanceof String) {
                return 1;
            }
            return 0;
        }
        if (o1.o instanceof String) {
            if (o2.o instanceof String) {
                return o1.o.toString().compareTo(o2.o.toString());
            } else if (o2.o instanceof Integer || o2.o instanceof User) {
                return -1;
            }
            return 0;
        }

        return 0;
    }
}

class SortType3 implements Comparator<Type>{

    @Override
    public int compare(Type o1, Type o2) {
        if(o1.o instanceof User) {
            if(o2.o instanceof User){
                return ((User) o1.o).getUser_name().compareTo(((User) o2.o).getUser_name());
            }
            else if(o2.o instanceof String)
                return ((User) o1.o).getUser_name().compareTo(o2.o.toString());
            else if(o2.o instanceof Integer) {
                return -1;
            }
            return 0;
        }
        else if(o1.o instanceof String) {
            if(o2.o instanceof User)
                return (o1.o.toString()).compareTo((((User) o2.o).getUser_name()));
            else if(o2.o instanceof  String){
                return o1.toString().compareTo(o2.toString());
            }
            else if(o2.o instanceof Integer) {
                return -1;
            }
            return 0;
        }
        else if(o1.o instanceof Integer){
            if(o2.o instanceof Integer){
                return (int) o1.o-(int) o2.o;
            }
            if(o2.o instanceof  String){
                return 1;
            }
            else if(o2.o instanceof User){
                return 1;
            }
            return 0;
        }
        return 0;
    }
}