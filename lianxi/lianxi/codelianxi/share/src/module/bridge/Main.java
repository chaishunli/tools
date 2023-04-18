package module.bridge;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName("module.bridge.MysqlDriver");
        Class.forName("module.bridge.OracleDriver");
        Connection conn=DriverManager.getConnection("localhost:1234/database","root","root");
        conn.show();
    }
}
