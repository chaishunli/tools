import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;


public class Test10 extends Object{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dayOfWeek = localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int dayOfMonth = localDateTime.getDayOfMonth();
        String month = localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = localDateTime.getYear();

        String time = LocalDateTime.now(ZoneId.of("Asia/Jakarta")).toLocalTime().withNano(0).toString();
        time = dayOfWeek + " " + dayOfMonth  + " " + month  + " "  + year  + " "  + time;
        System.out.println(time);

        BigDecimal b1=new BigDecimal("12.0");BigDecimal b2=new BigDecimal("12");
        System.out.println(b1 .equals(b2));

        String ddd = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(ddd);





    }

}
