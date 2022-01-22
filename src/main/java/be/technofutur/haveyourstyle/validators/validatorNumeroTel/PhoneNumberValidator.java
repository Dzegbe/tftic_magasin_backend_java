package be.technofutur.haveyourstyle.validators.validatorNumeroTel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements 
        ConstraintValidator<PhoneNumberConstraint,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  value!= null && value.matches("[0-9]+") && value.length()> 8 && value.length()<14;
    }
    
}
