package be.technofutur.haveyourstyle.validators.validatorString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = StringValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringConstaint {
    String message() default "One or more values doen't correspond to a letter or symbole( -  )";
    Class <?>[] groups() default{};
    Class <? extends Payload> [] payload() default{};
}
