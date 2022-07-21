package com.example.stageWeb.User.dto;

import com.example.stageWeb.User.model.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String access_token ;
    private String refrech_token ;
    private String name ;
    private AppUserRole role ;

}
