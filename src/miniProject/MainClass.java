package miniProject;

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

        u3.addresses.add(new Address("Gurgaon",201305));
        u3.addresses.add(new Address("Bengaluru",201305));

        List<User> users= Arrays.asList(u1,u2,u3);

        Set<Address> a=new TreeSet<>();



      for(User u: users){
          a.addAll(u.addresses);
      }


      List<Address> people=new ArrayList<>();

      people=a.stream().collect(Collectors.toList());

      users.stream().forEach(u->System.out.println(u.addresses));


    }
}
