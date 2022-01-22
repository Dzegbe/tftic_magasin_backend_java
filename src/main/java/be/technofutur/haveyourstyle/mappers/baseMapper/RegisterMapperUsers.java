package be.technofutur.haveyourstyle.mappers.baseMapper;

import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;

public interface RegisterMapperUsers {
    public Seller formToEntityIndividual(IndividualSellerRegisterForm formIndividual,Seller seller);
    public Seller formToEntityPrfessional(ProSellerRegisterForm formProfessional, Seller seller);
    public Customer register(CustomerRegisterForm formRegister, Customer customer );

}
