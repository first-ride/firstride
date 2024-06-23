package com.firstride.driverms.service;

import com.firstride.driverms.entity.DriverEntity;
import com.firstride.driverms.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepo driverRepo;
    /*
    * registering a new driver by saving it onto the DB
    * */
    public DriverEntity registerDriver(DriverEntity driver){
       return driverRepo.save(driver);
    }
    /*
    * finding all drivers
    * */
    public List<DriverEntity> findAll(){
        return driverRepo.findAll();
    }
    /*
    * finding a driver by Id
    * */
    public DriverEntity findById(Long id){
        Optional<DriverEntity> driverById = driverRepo.findById(id);
        return driverById.orElse(null);
    }
    /*
    * deleting a driver by Id
    * */
    public DriverEntity deleteById(Long id){
        Optional<DriverEntity> driver = driverRepo.findById(id);
        if(driver.isPresent()) {
            driverRepo.delete(driver.get());

        }
        return driver.orElse(null);
    }
    /*
    * updating a driver
    * */
    public Optional<DriverEntity> update(Long id, DriverEntity driver){
        Optional<DriverEntity> driverRepoById = driverRepo.findById(id);
        if (driverRepoById.isPresent()) {
            DriverEntity driverEntity = driverRepoById.get();
            driverEntity.setCity(driver.getCity());
            driverEntity.setAddress(driver.getAddress());
            driverEntity.setEmail(driver.getEmail());
            driverEntity.setFirstName(driver.getFirstName());
            driverEntity.setDateOfBirth(driver.getDateOfBirth());
            driverEntity.setLicensePlate(driver.getLicensePlate());
            driverEntity.setPhoneNumber(driver.getPhoneNumber());
            driverEntity.setVehicleId(driver.getVehicleId());
            driverEntity.setLastName(driver.getLastName());
            driverRepo.save(driverEntity);
        }
            return driverRepoById;
     }
}
