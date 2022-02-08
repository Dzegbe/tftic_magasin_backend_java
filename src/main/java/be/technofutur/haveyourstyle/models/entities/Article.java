package be.technofutur.haveyourstyle.models.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column(nullable = false)
    private String label;
    private float price;
    @Lob
    @ElementCollection(targetClass = String.class)
    private List<String> pictures;
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
    private String shortDesciption;
    private String numArticle;
    private String material;
    private String note;
}
