package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    @Column(nullable = false,unique = true)
    private String label;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BrandCollection> brandCollections;
    @ManyToOne
    private Seller seller;
    @OneToMany
    private List<Comment> comments;
    
}
