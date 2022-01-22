package be.technofutur.haveyourstyle.mappers.mapperImpl;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.CustomerMeasurementsDto;
import be.technofutur.haveyourstyle.models.entities.CustomerMeasurements;
import be.technofutur.haveyourstyle.models.forms.CustomerMeasurementsForm;

@Service
public class CustomerMeasurementsMapperImpl implements BaseMapper<CustomerMeasurementsDto,CustomerMeasurementsForm,CustomerMeasurements>{

    @Override
    public CustomerMeasurementsDto entityToDto(CustomerMeasurements entity) {
        if(entity != null){
            return CustomerMeasurementsDto.builder()
                                          .measurementId(entity.getMeasurementId())
                                          .hauteurBas(entity.getHauteurBas())
                                          .hauteurHaut(entity.getHauteurHaut())
                                          .tourBassin(entity.getTourBassin())
                                          .tourPoitrine(entity.getTourPoitrine())
                                          .tourTaille(entity.getTourTaille())
                                          .build();
        }
        return null;
    }

    @Override
    public CustomerMeasurements formToEntity(CustomerMeasurementsForm form,CustomerMeasurements cm) {
        if(form != null){
            cm.setHauteurBas(form.getHauteurBas());
            cm.setHauteurHaut(form.getHauteurHaut());
            cm.setTourBassin(form.getTourBassin());
            cm.setTourPoitrine(form.getTourPoitrine());
            cm.setTourTaille(form.getTourTaille());
            return cm;
        }
        return null;
    }

    @Override
    public CustomerMeasurements dtoToEntity(CustomerMeasurementsDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
