package be.technofutur.haveyourstyle.models.forms;


import lombok.Data;

@Data
public class ArticleForm {
    private String label;
    private float price;
    //image a vérifier
    private Long idBrand;
    private Infoform info;
    private int maxQuantity;
    private boolean canModifie;
}
