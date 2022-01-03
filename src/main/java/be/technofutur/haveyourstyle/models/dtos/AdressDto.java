package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdressDto {
    private Long adressId;
    private String country;
    private String city;
    private int zipCode;
    private String street;
    private int houseNumber;
    private List<String> function;
    
}
