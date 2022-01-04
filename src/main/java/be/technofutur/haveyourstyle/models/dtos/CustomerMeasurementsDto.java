package be.technofutur.haveyourstyle.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerMeasurementsDto {
    private Long measurementId;
    private float tourTaille;
    private float tourPoitrine;
    private float tourBassin;
    private float hauteurBas;
    private float hauteurHaut;
}
