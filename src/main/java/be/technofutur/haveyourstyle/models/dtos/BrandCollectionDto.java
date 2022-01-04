package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandCollectionDto {
    private Long brandCollectionId;
    private String label;
    private List<ArticleDto> articles;
    private String logo;
    
}
