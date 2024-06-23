package com.firstride.driverms.repository;

import com.firstride.driverms.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<DriverEntity,Long> {
}
