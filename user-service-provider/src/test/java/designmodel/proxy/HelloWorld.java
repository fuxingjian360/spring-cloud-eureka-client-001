package designmodel.proxy;

import java.math.BigDecimal;

public interface HelloWorld {
    ResponseObject sayHello(User user);
    ResponseObject sayHello2(User user,String str,int count);
    ResponseObject2 sayHello3(User user, BigDecimal mount);
}
