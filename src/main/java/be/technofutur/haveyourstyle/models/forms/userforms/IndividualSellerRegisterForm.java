package be.technofutur.haveyourstyle.models.forms.userforms;

import java.util.List;

import be.technofutur.haveyourstyle.models.forms.AdressForm;
import lombok.Data;

@Data
public class IndividualSellerRegisterForm {
    private String username;
    private List<AdressForm> adress;
    private String gsmNumber;
    private String telNumber;
    private String email;
    private String password;
    private String name;
    private String surname;
}
