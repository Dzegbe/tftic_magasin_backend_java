package be.technofutur.haveyourstyle.models.forms;


import org.hibernate.validator.constraints.Length;

import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
public class BrandCollectionForm {
    @StringConstaint
    @Length(min = 1,max = 50)
    private String label;
    private String logo;
}
