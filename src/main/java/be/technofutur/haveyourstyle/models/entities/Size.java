package be.technofutur.haveyourstyle.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.technofutur.haveyourstyle.models.embeddables.Measurement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "app_size")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Size {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;
    @Embedded
    @Column(nullable = false)
    private  List<Measurement> mesures;
    private String label;
}
