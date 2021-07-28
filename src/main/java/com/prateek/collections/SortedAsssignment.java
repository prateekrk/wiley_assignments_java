//package com.prateek.collections;
//
//import java.util.Comparator;
//import java.util.Set;
//import java.util.TreeSet;
//
//class  SortedAssignment{
//public static  void main(String args[]){
//    new SortingAssignment().main();
//}
//}
//
//
// class SortingAssignment {
//   void main() {
//        User u1 = new User(4,"Vanessa");
//        User u2 = new User(3,"Albert");
//        User u3 = new User(1,"Tom");
//        //Case 1
////		Set<Object> hash = new TreeSet<Object>(new SortByIntUserIDString());
//        //Case 2
////		Set<Object> hash = new TreeSet<Object>(new SortByStringUserIDInt());
//        //Case 3
//        Set<Object> s1 = new TreeSet<Object>(new SortByGlobalString());
//
//        s1.add(new User(1,"Adam"));
//        s1.add(new User(2,"User2"));
//        s1.add(1);
//        s1.add(2);
//        s1.add("Hello");
//        s1.add("hi");
//        s1.forEach(t->System.out.println(t.toString()));
//        System.out.println(s1);
//    }
//
//
//}
//
//class User{
//    private int id;
//    private String name;
//
//    public User(int id, String name) {
//        super();
//        this.id = id;
//        this.name = name;
//    }
//    @Override
//    public String toString() {
//        return id + " " + name ;
//    }
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//class SortByIntUserIDString implements Comparator<Object>{
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        // TODO Auto-generated method stub
//        if(o1 instanceof Integer) {
//            if(o2 instanceof Integer)
//                return (int)o1-(int)o2;
//            else
//                return -1;
//        }
//        else if(o1 instanceof User) {
//            if(o2 instanceof User)
//                return new SortByUserID().compare((User)o1,(User)o2);
//            else
//                return -1;
//        }
//        else if(o1 instanceof String){
//            if(o2 instanceof String)
//                return o1.toString().compareTo(o2.toString());
//            else
//                return 1;
//        }
//        return 0;
//    }
//
//}
//
//class SortByStringUserIDInt implements Comparator<Object>{
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        // TODO Auto-generated method stub
//        if(o1 instanceof String){
//            if(o2 instanceof String)
//                return o1.toString().compareTo(o2.toString());
//            else
//                return -1;
//        }
//        else if(o1 instanceof User) {
//            if(o2 instanceof User)
//                return new SortByUserID().compare((User)o1,(User)o2);
//            else
//                return -1;
//        }
//        else if(o1 instanceof Integer) {
//            if(o2 instanceof Integer)
//                return (int)o1-(int)o2;
//            else
//                return 1;
//        }
//        return 0;
//    }
//
//}
//
//class SortByGlobalString implements Comparator<Object>{
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        // TODO Auto-generated method stub
//        if(o1 instanceof Integer) {
//            if(o2 instanceof Integer)
//                return (int)o1-(int)o2;
//            else
//                return 1;
//        }
////---------------------------------------------------------------
////		else if(o2 instanceof Integer) {
////			if(o1 instanceof Integer)
////				return (int)o1-(int)o2;
////		}
////---------------------------------------------------------------
//        else if(o1 instanceof String){
//            if(o2 instanceof String)
//                return ((String)o1).compareTo((String)o2);
//            else if(o2 instanceof User)
//                return new SortByString().compare(o1, o2);
//            else
//                return -1;
//        }
////---------------------------------------------------------------
////		else if(o2 instanceof String){
////			if(o1 instanceof String)
////				return ((String)o1).compareTo((String)o2);
////			else if(o1 instanceof User)
////				return new SortByString().compare(o2, o1);
////			else
////				return -1;
////		}
////---------------------------------------------------------------
//        else if(o1 instanceof User) {
//            if(o2 instanceof User)
//                return new SortByUserName().compare((User)o1, (User)o2);
//            else if(o2 instanceof String)
//                return new SortByString().compare(o1, o2);
//            else
//                return -1;
//        }
////---------------------------------------------------------------
////		else if(o2 instanceof User) {
////			if(o1 instanceof User)
////				return new SortByUserName().compare((User)o1, (User)o2);
////			else if(o1 instanceof String)
////				return new SortByString().compare(o2, o1);
////			else
////				return -1;
////		}
////---------------------------------------------------------------
//        return 0;
//    }
//
//}
//
//class SortByUserID implements Comparator<User>{
//
//    @Override
//    public int compare(User o1, User o2) {
//        // TODO Auto-generated method stub
//        return o1.getId()-o2.getId();
//    }
//
//}
//
//
//class SortByString implements Comparator<Object>{
//    @Override
//    public int compare(Object o1, Object o2) {
//        // TODO Auto-generated method stub
//        if(o1 instanceof User) {
//            if(o2 instanceof String)
//                return ((User) o1).getName().compareTo((String) o2);
//        }
//        else if(o1 instanceof String) {
//            if(o2 instanceof User)
//                return ((String) o1).compareTo(((User) o2).getName());
//        }
//        return 0;
//    }
//}
//
//class SortByUserName implements Comparator<User> {
//
//    @Override
//    public int compare(User o1, User o2) {
//        // TODO Auto-generated method stub
//        return o1.getName().compareTo(o2.getName());
//    }
//
//}