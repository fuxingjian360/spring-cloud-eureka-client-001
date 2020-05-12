package designmodel.proxy.cglib;

import com.alibaba.fastjson.JSON;
import designmodel.proxy.User;

public class SayHello {
    public User sayHello(User user) {
        user.setName(user.getName() + ":update");
        System.err.println("调用中："+JSON.toJSON(user));
        return user;
    }

    public User sayHello2(User user) {
        user.setName(user.getName() + ":2update");
        System.err.println("2调用中："+JSON.toJSON(user));
        return user;
    }

    protected User sayHello3(User user) {
        user.setName(user.getName() + ":3update");
        System.err.println("3调用中："+JSON.toJSON(user));
        return user;
    }
}
