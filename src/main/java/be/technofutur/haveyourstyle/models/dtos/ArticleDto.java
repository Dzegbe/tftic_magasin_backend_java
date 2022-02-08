package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

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
    private String shortDesciption;
    private String numArticle;
    private String material;
    private String note;
}
