package com.example.stageWeb.User.ResetPassword;

public class ResetPasswordResponse {

    private String username ;

    public ResetPasswordResponse (){}

    public ResetPasswordResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
