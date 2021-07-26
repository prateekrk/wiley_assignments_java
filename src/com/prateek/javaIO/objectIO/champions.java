package com.prateek.javaIO.objectIO;

import java.io.Serializable;


public class champions implements Serializable{
    private  int year;
    private String name;

    champions(String name,int year){
        this.name=name;
        this.year=year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Year : "+year+" Driver Champion : "+name;
    }
}
