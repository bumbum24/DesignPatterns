package designpatterns.creational;

class Phone{
    private String model;
    private String battery;
    private String camera;

    public void setModel(String model) {
        this.model = model;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", battery='" + battery + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}


class PhoneBuilder{
    Phone phone = new Phone();
    public PhoneBuilder setModel(String model){
        phone.setModel(model);
        return this;
    }
    public PhoneBuilder setBattery(String battery){
        phone.setBattery(battery);
        return this;
    }
    public PhoneBuilder setCamera(String camera){
        phone.setCamera(camera);
        return this;
    }

    public Phone getPhone(){
        return phone;
    }

}
public class BuilderPattern {

    public static void main(String[] args) {
        Phone phone=new PhoneBuilder().setModel("Samsung").getPhone();
        System.out.println(phone);
    }

}
