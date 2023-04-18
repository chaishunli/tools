import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test12 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("1");list.add("2");list.add("3");
        list.forEach(t->{
            if(t.equals("2")){
                return;
            }
            System.out.println(t);
        });

    }
}
