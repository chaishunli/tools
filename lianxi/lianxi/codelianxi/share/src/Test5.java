@FunctionalInterface
public interface Test5 {
    void show();
    default void aa(){
        System.out.println("aa");
    }
    default void bb(){
        System.out.println("bb");
    }
    static void cc(){
        System.out.println("cc");
    }
    static  void dd(){
        System.out.println("dd");
    }
}
class Main implements  Test5{
    public static void main(String[] args) {
        Main m=new Main();
        m.aa();
        Test5.cc();



    }

    @Override
    public void show() {
        System.out.println("show");
    }
}
