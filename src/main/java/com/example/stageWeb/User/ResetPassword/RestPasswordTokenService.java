package com.example.stageWeb.User.ResetPassword;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RestPasswordTokenService {

    private ResetPasswordTokenRepository resetPasswordTokenRepository ;

    public RestPasswordTokenService(ResetPasswordTokenRepository resetPasswordTokenRepository) {
        this.resetPasswordTokenRepository = resetPasswordTokenRepository;
    }

    public void  saveConfirmationToken(ResetPasswordToken token){
        resetPasswordTokenRepository.save(token);
    }

    public Optional<ResetPasswordToken> getToken(String token){

        return resetPasswordTokenRepository.findByToken(token);
    }

    public  int setConfirmedAt(String token){
        return resetPasswordTokenRepository.updateConfirmedAt(token
                , LocalDateTime.now());
    }
}