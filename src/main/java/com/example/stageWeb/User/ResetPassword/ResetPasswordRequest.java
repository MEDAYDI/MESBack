package com.example.stageWeb.User.ResetPassword;

public class ResetPasswordRequest {
    private String token ;

    public ResetPasswordRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
