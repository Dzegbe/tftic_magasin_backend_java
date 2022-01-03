package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndividualSellerBrandDto {
    private Long brandId;
    private String label;
    private String logo;
    private List<BrandCollectionDto> brandCollections;
    private Long idSeller;
    private String name;
    private String surname;
}
