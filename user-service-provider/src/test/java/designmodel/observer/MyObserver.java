package designmodel.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    Logger logger = LoggerFactory.getLogger(MyObserver.class);

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.info("名称为：({})，方法update被调用，参数:({})", name, arg.toString());
    }
}
