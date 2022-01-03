package be.technofutur.haveyourstyle.models.dtos;

import be.technofutur.haveyourstyle.models.entities.Brand;
import be.technofutur.haveyourstyle.models.entities.Category;
import be.technofutur.haveyourstyle.models.entities.Info;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
    private Long articleId;
    private String size;
    private String label;
    private float price;
    private Byte[] pictures;
    private Brand brand;
    private Category category;
    private Info info;
}
