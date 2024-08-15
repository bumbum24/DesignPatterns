package designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

interface Component{
    void showPrice();
}

class LeafComponent implements Component{
    String name;
    int price;
    LeafComponent(String name,int price){
        this.name=name;
        this.price=price;
    }
    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}
class CompositeComponent implements Component {

    String name;

    public CompositeComponent(String name) {
        this.name = name;
    }

    List<Component> components = new ArrayList<>();

    public void add(Component component){
        components.add(component);
    }

    @Override
    public void showPrice() {
        System.out.println(this.name);
        for(Component leaf:components){
            leaf.showPrice();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Component mouse = new LeafComponent("mouse",500);
        Component keyboard = new LeafComponent("keyboard",600);

        Component ram = new LeafComponent("ram",8000);
        Component ssd = new LeafComponent("ssd",5000);

        CompositeComponent peripheral = new CompositeComponent("peri");
        peripheral.add(mouse);
        peripheral.add(keyboard);

        CompositeComponent cabinet = new CompositeComponent("cabinet");
        cabinet.add(ram);
        cabinet.add(ssd);

        CompositeComponent computer = new CompositeComponent("computer");
        computer.add(peripheral);
        computer.add(cabinet);

        computer.showPrice();
    }
}
