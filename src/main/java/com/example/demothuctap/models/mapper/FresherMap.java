package com.example.demothuctap.models.mapper;

import com.example.demothuctap.models.entity.Fresher;

public class FresherMap {
    public Fresher toFresher(FresherDTO fresherDTO) {
        Fresher fresher = new Fresher();
        fresher.setFresherId(fresherDTO.getFresherId());
        fresher.setFresherName(fresherDTO.getFresherName());
        fresher.setFresherAddress(fresherDTO.getFresherAddress());
        fresher.setFresherPhone(fresherDTO.getFresherPhone());
        fresher.setFresherEmail(fresherDTO.getFresherEmail());
        return fresher;
    }
}
