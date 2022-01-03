package be.technofutur.haveyourstyle.models.forms;

import java.util.List;

import be.technofutur.haveyourstyle.models.embeddables.Measurement;
import lombok.Data;

@Data
public class SizeForm {
    private List<Measurement> measurements;
    private String label;
}
