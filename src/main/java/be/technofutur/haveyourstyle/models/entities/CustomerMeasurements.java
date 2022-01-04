package be.technofutur.haveyourstyle.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "app_measurement")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerMeasurements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long measurementId;
    private float tourTaille;
    private float tourPoitrine;
    private float tourBassin;
    private float hauteurBas;
    private float hauteurHaut;
}
