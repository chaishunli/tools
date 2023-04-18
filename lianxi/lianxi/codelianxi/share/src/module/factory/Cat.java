package module.factory;

public class Cat {
    private String name="cat";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("miaomiao,i am a "+name);
    }

}
