package com.prateek.javaIO.objectIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriteChampionIO {
    public static void main(String args[]){
        try(
            FileOutputStream fos=new FileOutputStream("Champions")){
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            int year=1950;
            File f=new File("C:\\Users\\prate\\wiley_assignments\\src\\com\\prateek\\concurrentCollections\\collections\\names.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String d = myReader.nextLine();
                champions c=new champions(d,year);
                oos.writeObject(c);
                year++;
            }

            myReader.close();
            System.out.println("Successfully written");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
