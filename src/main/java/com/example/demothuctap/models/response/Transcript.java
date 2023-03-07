package com.example.demothuctap.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Transcript {
    private String fresherName;
    private String lp;
    private Double score01;
    private Double score02;
    private Double score03;
    private Double average;

    public Transcript(String fresherName, String lp, Double score01, Double score02, Double score03, Double average) {
        this.fresherName = fresherName;
        this.lp = lp;
        this.score01 = score01;
        this.score02 = score02;
        this.score03 = score03;
        this.average = (double)Math.round(average * 100) / 100;
    }
}
