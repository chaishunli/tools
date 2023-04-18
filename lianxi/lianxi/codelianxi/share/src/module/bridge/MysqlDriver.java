package module.bridge;

public class MysqlDriver implements Driver{
    public String driverName;
    static{
        System.out.println("加载mysql连接配置信息");
        MysqlDriver mysqlDriver=new MysqlDriver();
        mysqlDriver.driverName="mysql";
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
