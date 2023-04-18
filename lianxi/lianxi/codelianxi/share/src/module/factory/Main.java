package module.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static{
        //项目启动，加载beanfactory
        try {
            Class.forName("module.factory.BeanFactory");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Cat cat=(Cat)BeanFactory.getBean("cat");
        cat.show();

        Dog dog=(Dog)BeanFactory.getBean("dog");
        dog.show();
    }
}
