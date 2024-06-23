package firstride.ridems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {
    private Long id;
    private String userName;
    //private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    private String address;

    private String city;

    private Long vehicleId;

    private String licensePlate;
}