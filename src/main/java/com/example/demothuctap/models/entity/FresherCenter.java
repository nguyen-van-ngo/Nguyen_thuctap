package com.example.demothuctap.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fresher_center", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fresher_id", "center_code"})
})
public class FresherCenter {
    @Id
    @Column(name = "fresher_center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fresherCenterId;

    @ManyToOne
    @MapsId("fresherId")
    @JoinColumn(name = "fresher_id")
    @JsonIgnore
    Fresher fresher;

    @ManyToOne
    @MapsId("centerCode")
    @JoinColumn(name = "center_code")
    @JsonIgnore
    Center center;
}

