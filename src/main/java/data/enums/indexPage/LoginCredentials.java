package data.enums.indexPage;

public enum LoginCredentials {

    USER1("epam", "1234", "Piter Chailovskii");

    private String login;
    private String password;
    private String username;



    LoginCredentials(String login, String password, String username){
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
