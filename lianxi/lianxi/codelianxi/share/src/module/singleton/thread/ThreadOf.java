package module.singleton.thread;

import module.singleton.Singleton;

public class ThreadOf implements  Runnable{
    private  Singleton singleton;
    public ThreadOf(Singleton singleton){
        this.singleton = singleton;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        singleton.operatorMoney();
    }
}
