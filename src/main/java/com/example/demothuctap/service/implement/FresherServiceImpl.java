package com.example.demothuctap.service.implement;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.mapper.FresherDTO;
import com.example.demothuctap.models.mapper.FresherMap;
import com.example.demothuctap.models.response.Transcript;
import com.example.demothuctap.respositories.FresherRepository;
import com.example.demothuctap.service.serviceinterface.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class FresherServiceImpl implements FresherService {
    @Autowired
    FresherRepository fresherRepository;

    @Override
    public List<Fresher> getFresher() {
        List<Fresher> fresherList = fresherRepository.findAll();
        if (!fresherList.isEmpty()) {
            return fresherList;
        }
        return Collections.emptyList();
    }
    @Override
    public List<Transcript> getTranscript() {
        List<Transcript> transcriptList = fresherRepository.getTranscript();
        if(!transcriptList.isEmpty()) {
            return transcriptList;
        }
        return Collections.emptyList();
    }
    @Override
    public Fresher addFresher(FresherDTO fresherDTO) {
        FresherMap fresherMap = new FresherMap();
        Fresher fresher = fresherMap.toFresher(fresherDTO);
        List<Fresher> fresherList = fresherRepository.findByFresherId(fresher.getFresherId());
        if(fresherList.isEmpty()){
            return fresherRepository.save(fresher);
        }
        return null;
    }
    @Override
    public Fresher editFresher(FresherDTO fresherDTO) {
        FresherMap fresherMap = new FresherMap();
        return fresherRepository.findById(fresherDTO.getFresherId())
                .map(fresher -> {
                    fresher.setFresherName(fresherDTO.getFresherName());
                    fresher.setFresherAddress(fresherDTO.getFresherAddress());
                    fresher.setFresherPhone(fresherDTO.getFresherPhone());
                    fresher.setFresherEmail(fresherDTO.getFresherEmail());
                    return fresherRepository.save(fresher);
                }).orElseGet(()->{
                    Fresher fresher = fresherMap.toFresher(fresherDTO);
                    return fresherRepository.save(fresher);
                });
    }
    @Override
    public void deleteFresher(String id) {
        boolean exists = fresherRepository.existsById(id);
        if(exists) {
            fresherRepository.deleteById(id);
        }
    }

}

