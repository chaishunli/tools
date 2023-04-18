import java.awt.*;

public class Test9 {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot  robot = new Robot();
        while(true){
            System.out.println("start move");
            robot.mouseMove(100,0);
            System.out.println("sleep");
            Thread.sleep(4*60*1000);
        }
    }
}
