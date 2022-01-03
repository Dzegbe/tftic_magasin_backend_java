package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BrandDto {
    private Long brandId;
    private String label;
    private String logo;
    private Long IdSeller;
    private List<CommentDto> comments;
}
