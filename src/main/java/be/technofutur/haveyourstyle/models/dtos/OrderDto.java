package be.technofutur.haveyourstyle.models.dtos;

import java.util.Date;
import java.util.List;

import be.technofutur.haveyourstyle.models.embeddables.ArticleOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private Long orderId;
    private CustomerDto customer;
    private BrandDto brand;
    private List<ArticleOrder> articles;
    private String status;
    private Date date;
    private int orderPrice;
}
