package be.technofutur.haveyourstyle.models.forms.userforms;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import lombok.Data;

@Data
public class ProSellerRegisterForm {
    private AdressForm adress;
    @Pattern(regexp = "[0-9]+")
    private String gsmNumber;
    @Pattern(regexp = "([0-9]?)+")
    private String telNumber;
    @Email
    private String email;
    private String password;
    @Pattern(regexp = "([A-Z]{2,3})*[0-9]+")
    private String TvaNumber;
    @Pattern(regexp = "[0-9]+")
    private String companyNumber;
    @Length(max = 30)
    @Pattern(regexp = "[a-zA-Z]*[a-z ]+")
    private String companyName;
    @Pattern(regexp = "([0-9]?)+")
    private String fax;
}
