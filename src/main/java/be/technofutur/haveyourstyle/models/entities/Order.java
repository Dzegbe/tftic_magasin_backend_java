package be.technofutur.haveyourstyle.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.technofutur.haveyourstyle.models.embeddables.ArticleOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private Long idCustomer;
    @Column(nullable = false)
    private Long idBrand;
    @Embedded
    private List<ArticleOrder> articles;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private int orderPrice;
}
