package be.technofutur.haveyourstyle.models.forms.userforms;


import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.validators.validatorNumeroTel.PhoneNumberConstraint;
import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
@Validated
public class IndividualSellerRegisterForm {
    private AdressForm adress;
    @PhoneNumberConstraint
    private String gsmNumber;
    @PhoneNumberConstraint
    private String telNumber;
    @Email
    private String email;
    private String password;
    @NotBlank
    @Length(max = 30)
    @StringConstaint
    private String name;
    @NotBlank
    @Length(min = 3,max = 30)
    @StringConstaint
    private String surname;
    private List<String> socialNetwork;
}
