package com.herve.AgriSmartBackEnd.models;

import com.herve.AgriSmartBackEnd.common.BaseEntity;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "plots")
@Entity
public class Plot extends BaseEntity {
    private String name;
    private Double area;
    private String soilType;
    private String cropType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> eventList = new ArrayList<>();

     //+List~Evenement~ historique
       // +ajouterEvenement()
}
