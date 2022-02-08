package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
    @Column(nullable = false,unique = true)
    private String email;
    @Column(unique = true)
    private String TvaNumber;
    @Column(unique = true)
    private String companyNumber;
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
    @ElementCollection(targetClass = String.class)
    private List<String> socialNetwork;
    
}
