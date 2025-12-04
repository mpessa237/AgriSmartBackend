package com.herve.AgriSmartBackEnd.models;

import com.herve.AgriSmartBackEnd.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "user_alerts")
@Entity
public class UserAlert {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alert_id", nullable = false)
    private Alert alert;

    @Column(nullable = false)
    private Boolean isRead = false;


    public UserAlert(){}

    public UserAlert(User user, Alert alert) {
        this.user = user;
        this.alert = alert;
    }

}
