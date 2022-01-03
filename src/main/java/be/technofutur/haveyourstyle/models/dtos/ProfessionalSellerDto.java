package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter @Getter
public class ProfessionalSellerDto extends UserDto {
    private List<BrandDto> brands;
    private String email;
    private List<ArticleDto> articles;
    private int TvaNumber;
    private int companyNumber;
    private String fax;
}
