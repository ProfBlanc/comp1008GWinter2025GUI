package ca.georgiancollege.comp1008gwinter2025gui;

public class LoginModel {

    private String[][] logins = {
            {"admin", "password"},
            {"ben", "blanc"},
            {"comp1008", "rocks!"}
    };

    private int loginAttempts;
    private static final int MAX_LOGIN_ATTEMPTS = 5;

    void lockoutPolicy(){
        if(loginAttempts >= MAX_LOGIN_ATTEMPTS){
            throw new IllegalArgumentException("Your account has been locked!");
        }
    }
    public boolean processLogin(String username, String password){
        loginAttempts++;
        lockoutPolicy();
        for(int i = 0; i < logins.length; i++){
            if(logins[i][0].equals(username) && logins[i][1].equals(password)){
                loginAttempts = 0;
                return true;
            }
        }
        return false;
    }
}
