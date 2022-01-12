package be.technofutur.haveyourstyle.models.forms;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class AdressForm {

    @Length(min = 3,max = 30)
    @Pattern(regexp = "[A-Za-z]*[a-z]+")
    private String country;
    @Length(min = 3,max = 30)
    @Pattern(regexp = "[A-Za-z]*[a-z]+")
    private String city;
    @Length(min = 4)
    @Pattern(regexp = "[0-9]+")
    private String zipCode;
    @Length(min = 3,max = 30)
    @Pattern(regexp = "[a-zA-Z]*[a-z ]+")
    private String street;
    @Length(min = 1)
    @Pattern(regexp = "([0-9]{1,3})+([abcdefABCDEF]{0,1})")
    private String houseNumber;
}
