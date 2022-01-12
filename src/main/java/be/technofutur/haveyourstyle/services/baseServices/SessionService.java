package be.technofutur.haveyourstyle.services.baseServices;

import be.technofutur.haveyourstyle.models.dtos.CustomerDto;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.dtos.UserDto;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.UserFormLogin;

public interface SessionService {
    public UserDto login(UserFormLogin formLogin);
    public IndividualSellerDto registerSellerind(IndividualSellerRegisterForm formRegisterInd);
    public ProfessionalSellerDto registerSellerPro(ProSellerRegisterForm formRegisterPro);
    public CustomerDto registerCustomer(CustomerRegisterForm formRegisterCustomer);
}
