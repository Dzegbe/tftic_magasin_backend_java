package be.technofutur.haveyourstyle.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class BrandCollectionForm {
    private String label;
    private List<Long> articles;
    private String logo;
}
