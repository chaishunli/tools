package module.bridge;

public class DriverManager {
    private static Driver driver;

    public static void setDriver(Driver driver){
        DriverManager.driver=driver;
    }

    public static Connection getConnection(String url,String name,String password){
        return driver.getConnection(url,name,password);
    }
}
