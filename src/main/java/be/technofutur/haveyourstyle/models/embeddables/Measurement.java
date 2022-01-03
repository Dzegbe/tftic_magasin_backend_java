package be.technofutur.haveyourstyle.models.embeddables;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    private String label;
    private float measurement;
}
