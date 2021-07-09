package miniProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String id,name;
    List<Address> addresses=new ArrayList<Address>();
    public User(String id,String name){
        this.name=name;
        this.id=id;
    }

    @Override
    public String toString() {
        return "User :: "+this.id+"  "+this.name;
    }
}

