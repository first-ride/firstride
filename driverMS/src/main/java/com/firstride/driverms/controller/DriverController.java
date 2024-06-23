package com.firstride.driverms.controller;

import com.firstride.driverms.entity.DriverEntity;
import com.firstride.driverms.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<DriverEntity> registerDriver(@RequestBody DriverEntity driver) {
        return ResponseEntity.ok(driverService.registerDriver(driver));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<DriverEntity>> findAll(){
        return ResponseEntity.ok(driverService.findAll());
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<DriverEntity> findById(@PathVariable Long id){
        return ResponseEntity.ok(driverService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DriverEntity> deleteByID(@PathVariable Long id){
        return ResponseEntity.ok(driverService.deleteById(id));
    }
    @PatchMapping("updatedriver/{id}")
    public ResponseEntity<Optional<DriverEntity>> updateDriver(@PathVariable Long id,@RequestBody DriverEntity driver){
        return ResponseEntity.ok(driverService.update(id, driver));
    }





}
