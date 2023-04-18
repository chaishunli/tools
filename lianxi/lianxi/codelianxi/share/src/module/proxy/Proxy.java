package module.proxy;

public class Proxy implements Sourceable{
    private Source source;
    public Proxy(Source source){
        this.source=source;
    }
    @Override
    public void operator() {
        before();
        source.operator();
        after();
    }
    public void before(){
        System.out.println("帮助收集材料");
    }
    public void after(){
        System.out.println("处理后续问题");
    }
}
