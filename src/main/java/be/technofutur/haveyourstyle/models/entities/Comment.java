package be.technofutur.haveyourstyle.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "app_comment")
@Table(name = "app_comment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false)
    private Long idCustomer;
    private String commentMessage;
    @Column(nullable = false)
    private int rating;
    private String sellerAnswer;
    @Column(nullable = false)
    private Date date;
}
