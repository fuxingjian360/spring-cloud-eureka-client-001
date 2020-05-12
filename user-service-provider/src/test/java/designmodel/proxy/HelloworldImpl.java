package designmodel.proxy;

import java.math.BigDecimal;

public class HelloworldImpl implements HelloWorld {
    @Override
    public ResponseObject sayHello2(User user, String str, int count) {
        System.err.println("sayHello2(User user, String str, int count) ");
        return new ResponseObject();
    }

    @Override
    public ResponseObject2 sayHello3(User user, BigDecimal mount) {
        System.err.println("sayHello(User user, BigDecimal mount) ");
        return new ResponseObject2();
    }

    @Override
    public ResponseObject sayHello(User user) {
        System.err.println("hello world");
        return new ResponseObject();
    }
}
