package be.technofutur.haveyourstyle.models.dtos;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BrandDto {
    private Long id;
    private String label;
    private Long IdSeller;
//     private List<CommentDto> comments;
//     private List<BrandCollectionDto> brandCollections;
}
