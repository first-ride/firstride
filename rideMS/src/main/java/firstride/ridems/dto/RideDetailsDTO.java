package firstride.ridems.dto;

import firstride.ridems.entity.RideEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RideDetailsDTO {

    private DriverDTO driver;
    private Long id;
    private String origin;
    private String destination;


    private Long price;
    private LocalDate date;
    private Integer numOfSeats;
    private long driverid;


    public RideDetailsDTO(RideEntity ride, DriverDTO driver) {
        this.id = ride.getId();
        this.driver = driver;
        this.destination = ride.getDestination();
        this.price = ride.getPrice();
        this.numOfSeats = ride.getNumOfSeats();
        this.driverid = ride.getDriverid();
        this.date = ride.getDate();
        this.origin=ride.getOrigin();
    }
}