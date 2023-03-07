package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.FresherCenter;
import com.example.demothuctap.models.mapper.CenterDTO;

import java.util.List;

public interface CenterService {
    List<Center> getAllCenter();

    Center addCenter(CenterDTO centerDTO);

    void deleteCenter(String id);

    Center editCenter(CenterDTO centerDTO);

    FresherCenter addFresherToCenter(String centerCode, String fresherId);

    List<Fresher> getListFresherOfCenter(String string);
}

