package module.bridge;

public class Connection {
    private String url;
    private String userName;
    private String password;

    public void show(){
        System.out.println("驱动加载完成，连接地址为："+ this.getUrl());
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
