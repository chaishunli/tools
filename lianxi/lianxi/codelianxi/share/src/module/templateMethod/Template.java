package module.templateMethod;

public abstract class Template {

    public void one(){
        System.out.println("烧水");
    }
    public void two(){
        System.out.println("热水放入杯中");
    }
    abstract void three();
    public void four(){
        System.out.println("搅拌完成");
    }
    public void operator() {
        one();
        two();
        three();
        four();
    }
}
