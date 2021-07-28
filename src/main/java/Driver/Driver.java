package Driver;

import com.prateek.carrental.*;

public class Driver {
    Cars c;
    String name;
    Driver(String name){
        this.name=name;
    }

    public void setC(Cars c) {
        this.c = c;
    }

    public Cars getC() {
        return c;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
