package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.mapper.FresherDTO;
import com.example.demothuctap.models.response.Transcript;

import java.util.List;

public interface FresherService {
    List<Fresher> getFresher();

    List<Transcript> getTranscript();

    Fresher addFresher(FresherDTO fresherDTO);

    Fresher editFresher(FresherDTO fresherDTO);

    void deleteFresher(String id);
}
