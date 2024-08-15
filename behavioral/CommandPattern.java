package designpatterns.behavioral;

interface Command{
    public void execute();
}

class Light{
    boolean switchedOn;
    public void switchLight(){
        if(!switchedOn) {
            System.out.println(" Light On !!! ");
            switchedOn = !switchedOn;
        }
        else {
            System.out.println(" Light Off !!! ");
            switchedOn = !switchedOn;
        }
    }

}
class Room{
    Command command;

    Room(){}

    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }
}

class LivingRoom extends Room{
    LivingRoom(){
        super();
    }

    @Override
    public void executeCommand(){
        System.out.print(" Living Room : ");
        command.execute();
    }
}

class BathRoom extends Room{
    BathRoom(){
        super();
    }

    @Override
    public void executeCommand(){
        System.out.print(" Bath Room : ");
        command.execute();
    }
}

class TableLamp{
    Command command;

    TableLamp(){}

    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand(){
        System.out.print(" Table Lamp : ");
        command.execute();
    }
}
class LightSwitchCommand implements Command{
    Light light;

    LightSwitchCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.switchLight();
    }
}
public class CommandPattern {
    public static void main(String[] args) {
        Room livingRoom = new LivingRoom();
        Room bathRoom = new BathRoom();
        Command switchLightCommand = new LightSwitchCommand(new Light());
        livingRoom.setCommand(switchLightCommand);
        bathRoom.setCommand(switchLightCommand);
        livingRoom.executeCommand();
        livingRoom.executeCommand();
        bathRoom.executeCommand();
        bathRoom.executeCommand();

        TableLamp tableLamp = new TableLamp();
        tableLamp.setCommand(switchLightCommand);
        tableLamp.executeCommand();
        tableLamp.executeCommand();

    }
}
