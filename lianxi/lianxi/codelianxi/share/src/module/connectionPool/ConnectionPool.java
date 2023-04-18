package module.connectionPool;

import module.bridge.Connection;
import module.bridge.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ConnectionPool {
    private ConnectionPool(){};

    private static int core=5;
    private static Vector<Connection> conns=new Vector<Connection>();
    static{
        for(int i=0;i<core;i++){
            Connection conn=DriverManager.getConnection("localhost:1234/database","root","root");
            conns.add(conn);
        }
    }

    public static Connection getConnection(){
        if(conns.size()>=core){
            Connection conn=conns.get(0);
            conns.remove(conn);
            return conn;
        }else{
            System.out.println("no use , please wait");
            return null;
        }
    }

    public static void returnBack(Connection conn){
        conns.add(conn);
    }

    public static int getConnectoinCount(){
        return conns.size();
    }

}
