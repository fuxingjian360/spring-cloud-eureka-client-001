package designmodel.proxy;

public class Helloworld2Impl implements HelloWorld2 {
    @Override
    public String sayHello() {
        System.err.println("hello world2");
        return "hahaha2!!!";
    }
}
