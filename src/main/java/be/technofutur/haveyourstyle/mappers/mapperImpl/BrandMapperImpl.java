package be.technofutur.haveyourstyle.mappers.mapperImpl;


import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.BrandDto;
import be.technofutur.haveyourstyle.models.entities.Brand;
import be.technofutur.haveyourstyle.models.forms.BrandForm;
import be.technofutur.haveyourstyle.repositories.SellerRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BrandMapperImpl implements BaseMapper<BrandDto,BrandForm,Brand> {
    private final SellerRepository sellerRepository;

    public BrandMapperImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public BrandDto entityToDto(Brand entity) {
        if(entity != null){
            return BrandDto.builder()
                           .IdSeller(entity.getSeller().getUserId())
                           .id(entity.getBrandId())
                           .label(entity.getLabel())
                        //    .comments(entity.getComments().stream().map(commentMapper::entityToDto).collect(Collectors.toList()))
                           .build();
            // if(entity.getBrandCollections() != null){
            //     dto.setBrandCollections(entity.getBrandCollections().stream().map(brandCollectionMapper :: entityToDto)
            //                     .collect(Collectors.toList()));
            // }
        }
        return null;
    }

    @Override
    public Brand formToEntity(BrandForm form, Brand b) {
        if(form != null){   
            b.setLabel(form.getLabel());
            b.setSeller(sellerRepository.getById(form.getIdSeller()));
            return b;
        }
        return null;
    }

    @Override
    public Brand dtoToEntity(BrandDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
