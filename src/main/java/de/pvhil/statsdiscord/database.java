package de.pvhil.statsdiscord;

public class database {

    private String url;
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        main.name = username;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
        main.urlf = url;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        main.pw = password;
    }
    @Override
    public String toString() {

        return "\n username: " + username
                + "\npassword: " + password + "\n";
    }



}
