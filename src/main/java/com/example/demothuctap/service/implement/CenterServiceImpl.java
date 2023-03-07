package com.example.demothuctap.service.implement;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.FresherCenter;
import com.example.demothuctap.models.mapper.CenterDTO;
import com.example.demothuctap.models.mapper.CenterMap;
import com.example.demothuctap.respositories.CenterRepository;
import com.example.demothuctap.respositories.FresherCenterRepository;
import com.example.demothuctap.respositories.FresherRepository;
import com.example.demothuctap.service.serviceinterface.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    FresherCenterRepository fresherCenterRepository;
    @Autowired
    FresherRepository fresherRepository;

    @Override
    public List<com.example.demothuctap.models.entity.Center> getAllCenter(){
        List<com.example.demothuctap.models.entity.Center> centerList = centerRepository.findAll();
        if(!centerList.isEmpty()) {
            return centerList;
        }
        return Collections.emptyList();
    }
    @Override
    public com.example.demothuctap.models.entity.Center addCenter(CenterDTO centerDTO) {
        CenterMap centerMapMapper = new CenterMap();
        com.example.demothuctap.models.entity.Center center = centerMapMapper.toCenter(centerDTO);
        List<com.example.demothuctap.models.entity.Center> centerList = centerRepository.findByCenterCode(center.getCenterCode());
        if(!centerList.isEmpty()) {
            return centerRepository.save(center);
        }
        return null;
    }
    @Override
    public void deleteCenter(String id) {
        boolean exists = centerRepository.existsById(id);
        if(exists) {
            centerRepository.deleteById(id);
        }
    }
    @Override
    public com.example.demothuctap.models.entity.Center editCenter(CenterDTO centerDTO) {
        return centerRepository.findById(centerDTO.getCenterCode())
                .map(center -> {
                    center.setCenterCode(centerDTO.getCenterName());
                    center.setCenterAddress(centerDTO.getCenterAddress());
                    center.setCenterPhone(centerDTO.getCenterPhone());
                    return centerRepository.save(center);
                }).orElseGet(()->{
                    CenterMap centerMapMapper = new CenterMap();
                    com.example.demothuctap.models.entity.Center center = centerMapMapper.toCenter(centerDTO);
                    return centerRepository.save(center);
                });
    }
    @Override
    public FresherCenter addFresherToCenter(String centerCode, String fresherId) {
        FresherCenter fresherCenter = new FresherCenter();
        fresherRepository.findById(fresherId).ifPresent(fresherCenter::setFresher);
        centerRepository.findById(centerCode).ifPresent(fresherCenter::setCenter);
        return fresherCenterRepository.save(fresherCenter);
    }
    @Override
    public List<Fresher> getListFresherOfCenter(String string) {
        List<Fresher> fresherList = centerRepository.getFresherOfCenter(string);
        if(fresherList.isEmpty()) {
            return fresherList;
        }
        return Collections.emptyList();
    }
}

