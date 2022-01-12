package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfessionalSellerDto extends UserDto {

    private List<BrandDto> brands;
    private String email;
    private List<ArticleDto> articles;
    private String TvaNumber;
    private String companyNumber;
    private String companyName;
    private String fax;

   
    
}
