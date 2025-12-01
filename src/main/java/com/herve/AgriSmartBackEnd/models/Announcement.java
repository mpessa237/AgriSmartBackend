package com.herve.AgriSmartBackEnd.models;

import com.herve.AgriSmartBackEnd.common.BaseEntity;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "announcements")
@Entity
public class Announcement{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private Double quantity;
    private String location;
    private Date datePublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user ;
}
