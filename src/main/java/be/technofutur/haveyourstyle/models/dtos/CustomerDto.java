package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import be.technofutur.haveyourstyle.models.forms.CustomerMeasurementsForm;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter @Getter
@SuperBuilder
public class CustomerDto extends UserDto{
    private String name;
    private String surname;
    private String  email;
    private List<ArticleDto> wishList;
    private CustomerMeasurementsDto measurements;

}
