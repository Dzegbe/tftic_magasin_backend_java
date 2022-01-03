package be.technofutur.haveyourstyle.models.forms;

import lombok.Data;

@Data
public class AdressForm {
    private String country;
    private String city;
    private int zipCode;
    private String street;
    private int houseNumber;
}
