package be.technofutur.haveyourstyle.models.dtos;

import java.util.List;

import lombok.Data;

@Data
public abstract class UserDto {
    private Long userId;
    private String username;
    private List<AdressDto> adress;
    private String gsmNumber;
    private String telNumber;

    private List<String> roles;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean credentialsNonExpired;
}
