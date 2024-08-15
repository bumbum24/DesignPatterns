package designpatterns.creational;

public final class SingletonExample {

    private static SingletonExample singletonExample;
    private static int count=0;

    private SingletonExample() {
        count++;
    }

    public static SingletonExample getInstance(){
        if(singletonExample == null){
        synchronized (SingletonExample.class){
            if(singletonExample==null)
                 singletonExample = new SingletonExample();
        }
        }
        return singletonExample;
    }
    public void print(){
        System.out.println(singletonExample.hashCode()+ "num of instances : " + count);
    }
}

class SingletonTest1 implements Runnable{
    @Override
    public void run() {
        SingletonExample singletonExample=SingletonExample.getInstance();
        singletonExample.print();
        System.out.println("Run from 1");
    }
}

class SingletonTest2 implements Runnable {

    @Override
    public void run() {
        SingletonExample singletonExample = SingletonExample.getInstance();
        singletonExample.print();
        System.out.println("Run from 2");
    }
}

class SingletonTest{
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new SingletonTest1());
        Thread th2 = new Thread(new SingletonTest2());
        th1.start();
        th1.join();
        th2.start();

        th2.join();

    }
}