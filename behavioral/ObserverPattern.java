package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class Channel{
    List<Subscriber> subscriberList = new ArrayList<>();
    void subscribe(Subscriber sub){
        subscriberList.add(sub);
    }

    void videoUpload(){
        notifySubs();
    }

    void notifySubs(){
        for(Subscriber sub : subscriberList){
            sub.update();
        }
    }
}

class Subscriber{

    String name;
    Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    void update(){
        System.out.println("hey "+ name+ " New Video Uploaded");
    }
    void subscribeChannel(Channel ch){
        this.channel=ch;
    }

}
public class ObserverPattern {

    public static void main(String[] args) {
        Channel bumbum = new Channel();
        Subscriber s1=new Subscriber("Kumar");
        Subscriber s2=new Subscriber("Shubham");
        Subscriber s3=new Subscriber("Srivastava");

        s1.subscribeChannel(bumbum);
        s2.subscribeChannel(bumbum);
        s3.subscribeChannel(bumbum);

        bumbum.subscribe(s1);
        bumbum.subscribe(s2);
        bumbum.subscribe(s3);

        bumbum.videoUpload();
    }

}
