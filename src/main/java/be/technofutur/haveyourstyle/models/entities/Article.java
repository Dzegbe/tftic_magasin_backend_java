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
import javax.persistence.OneToMany;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Size> size;
    @Column(nullable = false)
    private String label;
    @Column(nullable = false)
    private float price;
    @Lob @Column(nullable = false)
    private Byte[] pictures;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    private Info info;
    private boolean canModifie;
    @Column(name = "quantity")
    private int maxQuantity;
    
}
