package ca.georgiancollege.comp1008gwinter2025gui;

public class ProfileModel {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ProfileModel(String username) {
        setUsername(username);
    }
}
