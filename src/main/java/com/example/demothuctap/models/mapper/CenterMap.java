package com.example.demothuctap.models.mapper;

public class CenterMap {
    public com.example.demothuctap.models.entity.Center toCenter(CenterDTO centerDTO) {
        com.example.demothuctap.models.entity.Center center = new com.example.demothuctap.models.entity.Center();
        center.setCenterCode(centerDTO.getCenterCode());
        center.setCenterName(centerDTO.getCenterName());
        center.setCenterAddress(centerDTO.getCenterAddress());
        center.setCenterPhone(centerDTO.getCenterPhone());
        return center;
    }
}
