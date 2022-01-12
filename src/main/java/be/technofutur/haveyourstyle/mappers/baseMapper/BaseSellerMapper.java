package be.technofutur.haveyourstyle.mappers.baseMapper;

import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.entities.Seller;

public interface BaseSellerMapper {
    public IndividualSellerDto entityToDtoIndividual(Seller seller);
    public ProfessionalSellerDto entityToDtoProfessional(Seller seller);
   
}
