package uweaccommodationsystem.model;

/**
 *
 * @author Connor
 */
public class User {
    
    private String userName;
    private String password;
    
    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String toString(){
        return userName + " " + password;
    }
    
}
