package be.technofutur.haveyourstyle.models.forms;

import lombok.Data;

@Data
public class CommentForm {
    private Long idCustomer;
    private String commentMessage;
    private int rating;
}
