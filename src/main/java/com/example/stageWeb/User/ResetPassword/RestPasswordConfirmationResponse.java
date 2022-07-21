package com.example.stageWeb.User.ResetPassword;

public class RestPasswordConfirmationResponse {

    private String password ;
    private String token ;

    public RestPasswordConfirmationResponse(String password, String token) {
        this.password = password;
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}