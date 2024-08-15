package designpatterns.creational;

interface Prototype{
    Bike getClone();
}
abstract class Vehicle{
    String name;

    Vehicle(){

    }
    Vehicle(Vehicle vehicle){
        this.name=vehicle.name;
    }

    abstract Vehicle getClone();
}

class Bike extends Vehicle{

    String brand;
    String colour;

    public void setColour(String colour) {
        this.colour = colour;
    }

    Bike(){
        super();

    }
    public Bike (Bike bike){
        super(bike);
        this.brand=bike.brand;
        this.colour= bike.colour;
    }

    @Override
    public Bike getClone() {
        return new Bike(this);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
public class PrototypePattern {
    public static void main(String[] args) {
        Bike b1 = new Bike();
        b1.name="Bike";
        b1.brand="Yamaha";
        b1.colour="red";

        Bike b2=b1.getClone();

        b1.setColour("Yellow");
        System.out.println(b1.toString());
        System.out.println(b2.toString());

    }
}
