package be.technofutur.haveyourstyle.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoDto {
    private Long infoId;
    private String confection;
    private String material;
    private String description;
    private String maintenance;
}
