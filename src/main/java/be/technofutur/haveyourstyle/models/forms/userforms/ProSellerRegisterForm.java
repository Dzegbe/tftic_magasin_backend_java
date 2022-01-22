package be.technofutur.haveyourstyle.models.forms.userforms;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.validators.validatorNumeroTel.PhoneNumberConstraint;
import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
public class ProSellerRegisterForm {
    private AdressForm adress;
    @PhoneNumberConstraint
    private String gsmNumber;
    @PhoneNumberConstraint
    private String telNumber;
    @Email
    private String email;
    private String password;
    @StringConstaint
    private String TvaNumber;
    @Pattern(regexp = "[0-9]+")
    private String companyNumber;
    @Length(max = 30)
    @StringConstaint
    private String companyName;
    @PhoneNumberConstraint
    private String fax;
}
