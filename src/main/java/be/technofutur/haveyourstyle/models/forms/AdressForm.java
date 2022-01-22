package be.technofutur.haveyourstyle.models.forms;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
public class AdressForm {

    @Length(min = 3,max = 30)
    @StringConstaint
    private String country;
    @Length(min = 3,max = 30)
    @StringConstaint
    private String city;
    @Length(min = 4, max = 5)
    @Pattern(regexp = "[0-9]+")
    private String zipCode;
    @Length(min = 3,max = 30)
    @StringConstaint
    private String street;
    @Length(min = 1)
    @Pattern(regexp = "^[0-9]{1,3}[a-fA-F]{0,1}$")
    private String houseNumber;
}
