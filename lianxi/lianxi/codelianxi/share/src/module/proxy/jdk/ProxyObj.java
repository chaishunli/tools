package module.proxy.jdk;

import module.proxy.Source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyObj implements InvocationHandler {
    private Source source;
    public ProxyObj(Source source){
        this.source=source;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前执行");
        Object obj=method.invoke(source,args);
        System.out.println("执行方法后执行");
        return obj;
    }
}
