import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        ExecutorService executorService=
                new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(3));
       for(int i=0;i<13;i++){
           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   System.out.println("123");
               }
           });
       }

        System.out.println("over");
    }
}
