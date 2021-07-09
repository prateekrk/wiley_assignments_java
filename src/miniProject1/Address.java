package miniProject1;

import java.util.ArrayList;
import java.util.List;

public class Address implements Comparable {
    private String city;
    private int zip;
    List<User> users=new ArrayList<>();
    public Address(String city,int zip){
        this.city=city;
        this.zip=zip;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Address :: "+"city : "+this.city+" zip : "+this.zip;
    }

    @Override
    public int hashCode() {
        return this.zip;
    }

    @Override
    public int compareTo(Object o) {
        return this.zip- ((Address) o).zip;
    }
}
