package module.proxy.jdk;

import module.proxy.Source;
import module.proxy.Sourceable;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Source source=new Source();
        ProxyObj proxyObj=new ProxyObj(source);
        Sourceable sourceable=(Sourceable)Proxy.newProxyInstance(source.getClass().getClassLoader(),
                source.getClass().getInterfaces(),proxyObj);
        sourceable.operator();
    }
}
