package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import be.technofutur.haveyourstyle.models.entities.Brand;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter @Getter
@SuperBuilder
public class IndividualSellerDto extends UserDto{
    private List<BrandDto> brands;
    private String email;
    private List<ArticleDto> articles;
    private String name;
    private String surname;
}
