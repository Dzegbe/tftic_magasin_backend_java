package be.technofutur.haveyourstyle.models.forms.userforms;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import lombok.Data;

@Data
@Validated
public class IndividualSellerRegisterForm {
    private AdressForm adress;
    @Pattern(regexp = "[0-9]+")
    private String gsmNumber;
    @Pattern(regexp = "([0-9]?)+")
    private String telNumber;
    @Email
    private String email;
    private String password;
    @NotBlank
    @Length(max = 30)
    @Pattern(regexp = "[a-zA-Z]*[a-z ]+")
    private String name;
    @NotBlank
    @Length(min = 3,max = 30)
    @Pattern(regexp = "[a-zA-Z]*[a-z ]+")
    private String surname;
}
