package be.technofutur.haveyourstyle.models.forms.userforms;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.models.forms.CustomerMeasurementsForm;
import lombok.Data;

@Data
@Validated
public class CustomerRegisterForm {

    private String password;
    private AdressForm adress;
    @Max(14) @Pattern(regexp = "[0-9]+")
    private String gsmNumber;
    @Pattern(regexp = "([0-9]?)+")
    private String telNumber;
    @NotBlank
    @Length(min = 3,max = 30)
    @Pattern(regexp = "[A-Za-z]*[a-z]+")
    private String name;
    @NotBlank
    @Length(min = 3,max = 30)
    @Pattern(regexp = "[A-Za-z]*[a-z]+")
    private String surname;
    @NotBlank
    @Email
    private String email;
    private CustomerMeasurementsForm measurments;  
}
