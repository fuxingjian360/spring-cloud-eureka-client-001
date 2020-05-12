package designmodel.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyTest {

    public static void main(String[] args) {
        jdkProxyTest001();
        //JDKProxyTest002();
        System.err.println("main over");
    }

    private static void jdkProxyTest001() {
        try {
            //项目类路径下面/com/sun/proxy/生成代理类
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
            Class[] a = new Class[]{JDKProxy.class};
            HelloWorld helloWorld = new HelloworldImpl();
            JDKProxy jdkProxy = new JDKProxy(helloWorld);
            HelloWorld targetObje = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), new Class[]{HelloWorld.class}, jdkProxy);
            User user = new User();
            user.setName("张三");
            user.setId(2);
            ResponseObject responseObject = targetObje.sayHello(user);
//            Runnable r1 = new Runnable(){
//                @Override
//                public void run() {
//                    System.err.println("hhhh");
//                    System.err.println("hhhh");
//                    System.err.println("hhhh");
//                    System.err.println("hhhh");
//                }
//            };
//            Thread t1 = new Thread(r1);
//            t1.start();
//            System.err.println("XXXXX结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void JDKProxyTest002() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        try {
            Class<?> clazz = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), HelloWorld.class);
            //Class<?> clazz = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(),HelloWorld2.class);
            Constructor<?> constructor = clazz.getConstructor(InvocationHandler.class);
            InvocationHandler invocationHandler = new JDKProxy(new HelloworldImpl());
            HelloWorld helloWorld = (HelloWorld) constructor.newInstance(invocationHandler);
            //HelloWorld2 helloWorld = (HelloWorld2) constructor.newInstance(invocationHandler);
            helloWorld.sayHello(new User(1, "张三"));
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
