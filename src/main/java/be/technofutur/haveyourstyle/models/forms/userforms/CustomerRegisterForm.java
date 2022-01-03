package be.technofutur.haveyourstyle.models.forms.userforms;

import java.util.List;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import lombok.Data;

@Data
public class CustomerRegisterForm {
    private String username;
    private String password;
    private List<AdressForm> adress;
    private String gsmNumber;
    private String telNumber;
    private String name;
    private String surname;
    private String email;  
}
