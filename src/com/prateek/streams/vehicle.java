package com.prateek.streams;

public class vehicle {
    String name;
    int year,topSpeed;
    public vehicle(String name,int year,int topSpeed){
        this.name=name;
        this.topSpeed=topSpeed;
        this.year=year;
    }
    public String toString(){
        return this.name+" "+this.year+" "+this.topSpeed;
    }
}
class Bikes{
    String name;
    int year,topSpeed;
    public Bikes(vehicle v) {
        this.name=v.name;
        this.topSpeed=v.topSpeed;
        this.year=v.year;
    }
    public String toString(){
        return this.name+" "+this.year+" "+this.topSpeed;
    }
}
class Car{
    String name;
    int year,topSpeed;
    public Car(vehicle v) {
        this.name=v.name;
        this.topSpeed=v.topSpeed;
        this.year=v.year;
    }
    public String toString(){
        return this.name+" "+this.year+" "+this.topSpeed;
    }
}