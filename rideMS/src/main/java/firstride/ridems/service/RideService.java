package firstride.ridems.service;

import firstride.ridems.dto.DriverDTO;
import firstride.ridems.dto.RideDetailsDTO;
import firstride.ridems.entity.RideEntity;
import firstride.ridems.repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RideService {
    @Autowired
    private RideRepo rideRepo;
    @Autowired
    private WebClient.Builder webClient;
    public ResponseEntity<RideEntity> createRide(RideEntity ride){
        return ResponseEntity.ok(rideRepo.save(ride));
    }
    public List<RideDetailsDTO> getAllRides() {
        //return rideRepo.findAll();
        List<RideEntity> all = rideRepo.findAll();
        List<RideDetailsDTO> rideDetailsDTOS = all.stream().map(x -> {
            DriverDTO driverDTO = fetchDriver(x.getDriverid()).block();
            return new RideDetailsDTO(x, driverDTO);

        }).collect(Collectors.toList());
        return rideDetailsDTOS;
    }
    public Optional<RideDetailsDTO> getRideById(Long id) {

        return rideRepo.findById(id).map(x-> {
            DriverDTO driver = fetchDriver(x.getDriverid()).block();
            return new RideDetailsDTO(x,driver);
                                    });


/*
        Optional<RideEntity> optionalRide = rideRepo.findById(id);
        if(optionalRide.isPresent()){
            DriverDTO driver = fetchDriver(optionalRide.get().getDriverid()).block();
            return Optional.of(new RideDetailsDTO(optionalRide.get(), driver));
        }
        return Optional.of(new RideDetailsDTO(null, null));
*/


    }
    public Optional<RideEntity> deleteRide(Long id){
        Optional<RideEntity> byId = rideRepo.findById(id);
        if (byId.isPresent())
        {
            rideRepo.delete(byId.get());
        }
        return byId;
    }
    public Optional<RideEntity> update(Long id, RideEntity ride){
        Optional<RideEntity> byId = rideRepo.findById(id);
        if(byId.isPresent())
        {
            RideEntity entity = byId.get();
            entity.setDate(ride.getDate());
            entity.setDriverid(ride.getDriverid());
            entity.setDestination(ride.getDestination());
            entity.setOrigin(ride.getOrigin());
            entity.setPrice(ride.getPrice());
            entity.setNumOfSeats(ride.getNumOfSeats());
            rideRepo.save(entity);
        }
        return byId;
    }
    public Mono<DriverDTO> fetchDriver(Long id){
        return webClient.build()
                .get()
                .uri("http://localhost:8081/driver/findById/{id}", id)
                .retrieve()
                .bodyToMono(DriverDTO.class);
    }



}
