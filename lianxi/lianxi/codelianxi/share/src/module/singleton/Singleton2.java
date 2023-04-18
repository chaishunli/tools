package module.singleton;

public class Singleton2{
    private Singleton2(){}
    private static Singleton2 Singleton2=new Singleton2();

    public static Singleton2 getInstance(){
        return Singleton2;
    }



    private int tickets=10;
    public synchronized   void operatorMoney() {
        this.tickets = this.tickets-1;
        System.out.println(this.tickets);
    }
}
