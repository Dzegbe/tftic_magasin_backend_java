package be.technofutur.haveyourstyle.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryStyleDto {
    private Long categoriId;
    private String label;
}
