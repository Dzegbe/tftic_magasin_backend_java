package be.technofutur.haveyourstyle.models.dtos;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private String customerName;
    private String customerUrname;
    private Long customerId;
    private String comment;
    private int rating;
    private String sellerAnswer;
    private Date date;
}
