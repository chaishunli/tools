import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test11 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Map<String,String> map2 = new HashMap();
        map2.put("a","4");
        map2.put("b","5");
        map2.put("c","6");
        List<Map<String,String>> list = Arrays.asList(map,map2);
        List result = list.stream().map(l->l.get("a")).collect(Collectors.toList());
        System.out.println();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));
        threadPoolExecutor.execute(()->{

        });
    }
}
