package module.proxy;

public class Main {
    public static void main(String[] args) {
        Source source=new Source();
        Proxy proxy=new Proxy(source);
        proxy.operator();
    }
}
