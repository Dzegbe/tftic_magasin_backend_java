package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import be.technofutur.haveyourstyle.models.entities.Info;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
    private Long id;
    private String label;
    private float price;
    private List<String> pictures;
    private BrandDto brand;
    private Info info;
    private boolean canModifie;
}
