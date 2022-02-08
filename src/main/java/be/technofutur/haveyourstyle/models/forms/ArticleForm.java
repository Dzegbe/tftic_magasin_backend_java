package be.technofutur.haveyourstyle.models.forms;


import java.util.List;

import org.hibernate.validator.constraints.Length;

import be.technofutur.haveyourstyle.validators.validatorString.StringConstaint;
import lombok.Data;

@Data
public class ArticleForm {
    @StringConstaint
    @Length(min = 1,max = 50)
    private String label;
    private float price;
    private List<String> pictures;
    private Long idBrand;
    private String shortDesciption;
    private String numArticle;
    private String material;
    private String note;
    
}
