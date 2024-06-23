package firstride.ridems.controller;

import firstride.ridems.dto.RideDetailsDTO;
import firstride.ridems.entity.RideEntity;
import firstride.ridems.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RideController {
    @Autowired
    private RideService rideService;
    @PostMapping("add")
    public ResponseEntity<RideEntity> creatRide(@RequestBody RideEntity ride){
        return rideService.createRide(ride);
    }
    @GetMapping("findAll")
    public ResponseEntity<List<RideDetailsDTO>> findAll(){
        return ResponseEntity.ok(rideService.getAllRides());
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<RideDetailsDTO> getRideById(@PathVariable Long id) {
        return rideService.getRideById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("del/{id}")
    public ResponseEntity<RideEntity> deleteRide(@PathVariable Long id){
        return rideService.deleteRide(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("update/{id}")
    public ResponseEntity<RideEntity> update(@PathVariable Long id, @RequestBody RideEntity newRide){
        return  rideService.update(id,newRide).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
