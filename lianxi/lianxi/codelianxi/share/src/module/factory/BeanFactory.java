package module.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BeanFactory {
    private static Map<String,Object> beans=new HashMap<String,Object>();
    static{
        //装载bean
        try{
            //加载Cat类文件
            Class clazz=Class.forName("module.factory.Cat");
            Constructor contructor=clazz.getConstructor();
            String beanName=clazz.getSimpleName();
            //beanName 首字母变小写
            beanName=beanName.substring(0,1).toLowerCase()+beanName.substring(1);
            Object t=contructor.newInstance();
            beans.put(beanName,t);

            //加载Dog类文件
            Class clazz2=Class.forName("module.factory.Dog");
            Constructor contructor2=clazz2.getConstructor();
            String beanName2=clazz2.getSimpleName();
            beanName2=beanName2.substring(0,1).toLowerCase()+beanName2.substring(1);
            Object t2=contructor2.newInstance();
            beans.put(beanName2,t2);

        }catch (Exception ex){
            System.out.println("");
        }

    }
    public static Object getBean(String name){
        Object obj=beans.get(name);
        return obj;
    }
}
