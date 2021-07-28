package sortingAlgos;


class Animal{
    String type,name,sound;
    Animal(String type,String name,String sound){
        this.name=name;
        this.sound=sound;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Name : "+name+" Type : "+type+" Sound : "+sound;
    }
}
public class AnimalZoo {
    public static void main(String args[]){
        Animal zoo[]=new Animal[5];

        zoo[0]=new Animal("herbivorous","Elephant","trumpet");
        zoo[1]=new Animal("Carnivorous","Tiger","growl");
        zoo[2]=new Animal("Herbivorous","Rhinos","xyz");
        zoo[3]=new Animal("Carnivorous","Lions","roar");
        zoo[4]=new Animal("Herbivorous","Gaur","snort/moo");
        for(Animal a:zoo){
            System.out.println(a.toString());
        }
    }
}
