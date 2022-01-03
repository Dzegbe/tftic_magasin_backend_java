package be.technofutur.haveyourstyle.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class BrandForm {
    private String label;
    private String logo;
    private List<BrandCollectionForm> branCollections;
    private Long idSeller;
}
