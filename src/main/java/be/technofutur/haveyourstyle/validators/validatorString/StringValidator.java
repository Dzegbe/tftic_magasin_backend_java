package be.technofutur.haveyourstyle.validators.validatorString;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<StringConstaint,String>  {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^[a-zA-Z]+[a-zA-Z -]+[a-z]$");
    }
    
}
