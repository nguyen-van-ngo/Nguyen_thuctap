package com.example.demothuctap.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "center")
public class Center {
    @Id
    @Column(name = "code")
    private String centerCode;
    @Column(name = "name")
    private String centerName;
    @Column(name = "address")
    private String centerAddress;
    @Column(name = "phone")
    private String centerPhone;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<FresherCenter> fresherCenters;
}

