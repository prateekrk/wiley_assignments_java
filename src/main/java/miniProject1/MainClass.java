package miniProject1;


import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

   public static void main(String args[]){

       User u1=new User("1","user1");
       User u2 =new User("2","user2");
       User u3=new User("3","user3");

       u1.addresses.add(new Address("delhi",110001));
       u1.addresses.add(new Address("Bengaluru",560001));


       u2.addresses.add(new Address("Gurgaon",201305));
       u2.addresses.add(new Address("Bengaluru",560001));

       u3.addresses.add(new Address("Gurgaon",201306));
       u3.addresses.add(new Address("Bengaluru",560001));

       Map<Address,List<User>> map= new TreeMap<>();

       List<User> users= Arrays.asList(u1,u2,u3);

       Set<Address> addresses=new TreeSet<>();


       for(User u: users ){
           addresses.addAll(u.addresses);
       }

       System.out.println( addresses);

       System.out.println(users);
       for(Address a:addresses){
           List<User> u0=users.stream().filter(u->u.addresses.stream().anyMatch(a1->a1.getZip()==a.getZip())).collect(Collectors.toList());
            map.put(a,u0);
       }
        int car1=5;
       int car2=6;
       System.out.println(car1+car2+"="+car2+car1);
       map.forEach((a,u)->System.out.println(a+"\n"+u));
   }
}

