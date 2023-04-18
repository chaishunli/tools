package module.singleton.thread;

import module.singleton.Singleton;

public class Main {


    public static void main(String[] args) {
        Singleton singleton= Singleton.getInstance();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new ThreadOf(singleton));
            thread.start();
        }

    }
}
