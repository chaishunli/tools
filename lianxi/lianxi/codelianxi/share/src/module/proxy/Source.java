package module.proxy;

public class Source implements Sourceable{
    @Override
    public void operator() {
        System.out.println("提供材料");
    }
}
