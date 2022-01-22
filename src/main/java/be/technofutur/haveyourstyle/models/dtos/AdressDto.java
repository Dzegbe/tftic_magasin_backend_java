package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdressDto {
    private Long id;
    private String country;
    private String city;
    private String zipCode;
    private String street;
    private String houseNumber;
    private List<String> function;
    
}
