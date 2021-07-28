package com.prateek.javaIO.objectIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadChampionIO {
    public static void main(String args[]){
        try(FileInputStream fis=new FileInputStream("Champions")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                    try {
                        champions c = (champions) ois.readObject();
                        System.out.println(c.toString());
                    }
                    catch (Exception e){
                        break;
                    }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
/*java.io.InvalidClassException:
com.sujata.objectio.Person; local class incompatible: stream classdesc
serialVersionUID = 8690758045384365723,
local class serialVersionUID = -305011557217068981
 */