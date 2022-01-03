package be.technofutur.haveyourstyle.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class ArticleForm {
    private List<SizeForm> sizes;
    private String label;
    private float price;
    //image a vérifier
    private Long idBrand;
    private Long idCategory;
    private Infoform info;
    private int maxQuantity;
}
