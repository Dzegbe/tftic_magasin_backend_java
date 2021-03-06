package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class UserDto {
    private Long id;
    private String username;
    private List<AdressDto> adress;
    private String gsmNumber;
    private String telNumber;

    private List<String> roles;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean credentialsNonExpired;

    private String token;
}
