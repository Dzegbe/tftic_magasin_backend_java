package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Builder
public class CustomerDto extends UserDto{
    private String name;
    private String surname;
    private String  email;
    private List<ArticleDto> wishList;

}
