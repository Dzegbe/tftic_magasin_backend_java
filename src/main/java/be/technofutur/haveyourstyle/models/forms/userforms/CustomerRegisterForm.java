package be.technofutur.haveyourstyle.models.forms.userforms;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.models.forms.CustomerMeasurementsForm;
import be.technofutur.haveyourstyle.validators.validatorNumeroTel.PhoneNumberConstraint;
import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
@Validated
public class CustomerRegisterForm {

    private String password;
    private AdressForm adress;
    @PhoneNumberConstraint
    private String gsmNumber;
    @PhoneNumberConstraint
    private String telNumber;
    @NotBlank
    @Length(min = 3,max = 30)
    @StringConstaint
    private String name;
    @NotBlank
    @Length(min = 3,max = 30)
    @StringConstaint
    private String surname;
    @NotBlank
    @Email
    private String email;
    private CustomerMeasurementsForm measurments;  
}
