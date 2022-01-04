package be.technofutur.haveyourstyle.mappers;

import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;

public interface BaseSellerMapper {
    public IndividualSellerDto entityToDtoIndividual(Seller seller);
    public ProfessionalSellerDto entityToDtoProfessional(Seller seller);
    public Seller formToEntityIndividual(IndividualSellerRegisterForm formIndividual);
    public Seller formToEntityPrfessional(ProSellerRegisterForm formProfessional);
}
