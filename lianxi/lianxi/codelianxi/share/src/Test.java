import netscape.javascript.JSObject;

import java.io.Serializable;

public class Test implements Serializable {
    public static void main(String[] args) {
        Source source=new Source();
        System.out.println(Operator.operator(source));
    }
}
class Source implements Sourceable{
    public String name="ccc";
    public String password="123";

    @Override
    public String toString() {
        return "{'name':'ccc','password':'123'}";
    }
}

interface  Sourceable{

}

class Operator{
    public static String  operator(Object obj){
        if(obj instanceof  Sourceable){
            String value=obj.toString();
            return value;
        }else {
            return "";
        }
    }
}

