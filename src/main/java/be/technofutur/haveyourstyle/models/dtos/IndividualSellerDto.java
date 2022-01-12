package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class IndividualSellerDto extends UserDto{
    private List<BrandDto> brands;
    private String email;
    private List<ArticleDto> articles;
    private String name;
    private String surname;
}
