package Modelos;

public class LoginVo {

    private String Username, password;

    public LoginVo(String Username, String password) {
        this.Username = Username;
        this.password = password;
    }

    public LoginVo() {
    }

    @Override
    public String toString() {
        return "LoginVo{" + "Username=" + Username + ", password=" + password + '}';
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
