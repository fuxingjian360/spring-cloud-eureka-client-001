package designmodel.proxy.cglib;

import com.alibaba.fastjson.JSON;
import designmodel.proxy.User;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.io.IOException;

public class CGLibProxyTest {
    public static void main(String[] args) {
        // 生成代理类class的路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\githubproject\\spring-cloud-eureka-client-001\\com\\sun\\cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SayHello.class);
        enhancer.setCallback(new MyMethodInterceptor());
        //Object targetObject = enhancer.create();
        SayHello sayHello = (SayHello) enhancer.create();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        User resUser = sayHello.sayHello3(user);
    }
}
