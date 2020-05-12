package designmodel.observer;

public class MyObserverTest {
    public static void main(String[] args) {
        MyObserver myObserver01 = new MyObserver("MyObserver001");
        MyObserver myObserver02 = new MyObserver("MyObserver002");
        MyObserverable myObserverable = new MyObserverable();
        myObserverable.addObserver(myObserver01);
        myObserverable.addObserver(myObserver02);
        myObserverable.setChanged();
        myObserverable.notifyObservers("hello,World");
    }
}
