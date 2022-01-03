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

@Entity
@Table(name ="app_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Info {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;
    private String confection;
    private String material;
    private String description;
    private String maintenance;
    
}
