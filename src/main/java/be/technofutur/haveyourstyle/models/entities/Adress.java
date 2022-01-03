package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_adress")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adressId;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private int zipCode;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int houseNumber;
    //function , is how the adress be going use, like delevery.
    @ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
    private List<String> function;
}
    
