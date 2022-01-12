package be.technofutur.haveyourstyle.mappers.baseMapper;

import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;

public interface RegisterMapperUsers {
    public Seller formToEntityIndividual(IndividualSellerRegisterForm formIndividual);
    public Seller formToEntityPrfessional(ProSellerRegisterForm formProfessional);
    public Customer register(CustomerRegisterForm formRegister);

}
