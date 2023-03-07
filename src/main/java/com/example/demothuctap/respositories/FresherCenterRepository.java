package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.FresherCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FresherCenterRepository extends JpaRepository<FresherCenter, Long> {
}
