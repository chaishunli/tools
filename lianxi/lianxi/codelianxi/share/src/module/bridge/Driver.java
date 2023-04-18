package module.bridge;

public interface Driver {
    Connection getConnection(String url,String name,String password);
}
