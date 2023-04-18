public class Test8 {
    public static void main(String[] args) {
        int times=863;
        int day=times/86400;
        int hour=(times%86400)/3600;
        int min=((times%86400)%3600)/60;
        int ss=((times%86400)%3600)%60;
        System.out.println("day:"+day);
        System.out.println("hour:"+hour);
        System.out.println("min:"+min);
        System.out.println("ss:"+ss);
    }
}
