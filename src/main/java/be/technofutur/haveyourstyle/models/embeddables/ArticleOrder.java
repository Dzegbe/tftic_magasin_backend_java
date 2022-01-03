package be.technofutur.haveyourstyle.models.embeddables;



import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleOrder {
   private Long articleId;
   private int quantity;
}
