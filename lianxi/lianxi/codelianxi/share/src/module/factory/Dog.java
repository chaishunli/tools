package module.factory;

public class Dog {
    private String name="dog";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("wangwang,i am a "+name);
    }



}
