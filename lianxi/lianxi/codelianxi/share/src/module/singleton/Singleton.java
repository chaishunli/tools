package module.singleton;

public class Singleton {
    private volatile  static Singleton singleton=null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                    return singleton;
                }
                return singleton;

            }
        }
        return singleton;
    }



    private int tickets=10;
    public  synchronized void operatorMoney() {
        this.tickets = this.tickets-1;
        System.out.println(this.tickets);
    }
}

