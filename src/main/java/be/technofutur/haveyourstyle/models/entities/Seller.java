package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "app_seller")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public class Seller extends User {
    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "seller",
                orphanRemoval = true)
    private List<Brand> brands;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany
    private List<Article> articles;
    @Column(unique = true)
    private int TvaNumber;
    @Column(unique = true)
    private int companyNumber;
    @Column(unique = true)
    private String fax;
    @Column(unique = true)
    private String companyName;
    private String name;
    private String surname;
    //if he is individual seller or professionnal seller
    private String functionSeller;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CategoryStyle> style;
    
}
