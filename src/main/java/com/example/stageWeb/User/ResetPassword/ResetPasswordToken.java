package com.example.stageWeb.User.ResetPassword;

import com.example.stageWeb.User.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ResetPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String token ;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt ;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name ="app_user_id"
    )
    private User user ;

    public ResetPasswordToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt , User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}