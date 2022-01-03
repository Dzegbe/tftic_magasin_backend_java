package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import be.technofutur.haveyourstyle.models.entities.Brand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Builder
public class IndividualSellerDto extends UserDto{
    private List<Brand> brands;
    private String email;
    private List<ArticleDto> articles;
    private String name;
    private String surname;
}
