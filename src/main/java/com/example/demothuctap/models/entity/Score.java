package com.example.demothuctap.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fresher_id", "subject_id"})
})
public class Score {
    @Id
    @Column(name = "score_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;
    @Column
    private Double score01;
    @Column
    private Double score02;
    @Column
    private Double score03;

    @ManyToOne()
    @MapsId("fresherId")
    @JoinColumn(name = "fresher_id")
    @JsonIgnore
    Fresher fresher;

    @ManyToOne()
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    Subject subject;
}

