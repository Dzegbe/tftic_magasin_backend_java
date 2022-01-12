package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class CustomerDto extends UserDto{
    private String name;
    private String surname;
    private String  email;
    private List<ArticleDto> wishList;
    private CustomerMeasurementsDto measurements;

}
