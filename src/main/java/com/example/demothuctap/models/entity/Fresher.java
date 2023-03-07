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
@Table(name = "fresher")
public class Fresher {
    @Id
    @Column(name = "id")
    private String fresherId;
    @Column(name = "name")
    private String fresherName;
    @Column(name = "address")
    private String fresherAddress;
    @Column(name = "phone")
    private String fresherPhone;
    @Column(name = "email")
    private String fresherEmail;

    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<FresherCenter> fresherCenters;
    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<Score> scores;

    public Fresher(String fresherId, String fresherName, String fresherAddress, String fresherPhone, String fresherEmail) {
        this.fresherId = fresherId;
        this.fresherName = fresherName;
        this.fresherAddress = fresherAddress;
        this.fresherPhone = fresherPhone;
        this.fresherEmail = fresherEmail;
    }
}

