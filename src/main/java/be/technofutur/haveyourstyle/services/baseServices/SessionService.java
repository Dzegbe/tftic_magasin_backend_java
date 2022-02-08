package be.technofutur.haveyourstyle.services.baseServices;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

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
    public String registerCustomer(CustomerRegisterForm formRegisterCustomer,String siteURL)
        throws UnsupportedEncodingException,MessagingException;
}
