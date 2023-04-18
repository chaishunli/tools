package module.connectionPool;

import module.bridge.Connection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("module.bridge.MysqlDriver");

        Connection conn=ConnectionPool.getConnection();
        conn.show();//use connection
        System.out.println(ConnectionPool.getConnectoinCount());

        ConnectionPool.returnBack(conn);//return back connection
        System.out.println(ConnectionPool.getConnectoinCount());

    }
}
