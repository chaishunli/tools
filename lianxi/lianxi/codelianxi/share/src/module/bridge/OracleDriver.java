package module.bridge;

public class OracleDriver  implements Driver{
    public String driverName;
    static{
        System.out.println("加载oracle连接配置信息");
        OracleDriver mysqlDriver=new OracleDriver();
        mysqlDriver.driverName="oracle";
        DriverManager.setDriver(mysqlDriver);

    }

    @Override
    public Connection getConnection(String url,String name,String password) {
        Connection connection=new Connection();
        connection.setUrl(url);
        connection.setUserName(name);
        connection.setPassword(password);
        return connection;
    }
}
