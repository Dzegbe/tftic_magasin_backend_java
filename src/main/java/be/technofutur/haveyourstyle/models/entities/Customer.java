package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "app_customer")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@SuperBuilder
public class Customer extends User{
    private String name;
    private String surname;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany
    private List<Article> wishList;
    @OneToOne
    private CustomerMeasurements measurement;
}
