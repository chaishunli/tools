public class Test2 {
    public static void main(String[] args) {
        Damo damo=new Damo();
        if(damo instanceof  Sourceable1){
            System.out.println("is 1");
        }
        if(damo instanceof  Sourceable2){
            System.out.println("is 2");
        }
    }
}
class Damo implements Sourceable1,Sourceable2{

}
interface  Sourceable1{

}
interface  Sourceable2{

}
