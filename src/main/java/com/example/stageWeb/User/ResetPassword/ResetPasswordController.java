package com.example.stageWeb.User.ResetPassword;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/resetpassword")
public class ResetPasswordController  {



    private ResetPasswordService resetPasswordService ;

    public   ResetPasswordController (ResetPasswordService resetPasswordService){
        this.resetPasswordService=resetPasswordService;
    }


    @PostMapping()
    public ResponseEntity<ResetPasswordRequest> ResetPassword(@RequestBody ResetPasswordResponse response){

        String token =   resetPasswordService.ResetPasswordEmail(response.getUsername());
        ResetPasswordRequest request = new ResetPasswordRequest(token);
       return  new ResponseEntity<>(request,HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<HttpStatus> ConfirmTokenResetPassword(@RequestBody RestPasswordConfirmationResponse response){
        resetPasswordService.ResetPassword(response.getToken(),response.getPassword());
        return new ResponseEntity<>( HttpStatus.OK);

    }
}