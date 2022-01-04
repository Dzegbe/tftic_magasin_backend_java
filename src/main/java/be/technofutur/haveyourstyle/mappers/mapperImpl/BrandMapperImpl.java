package be.technofutur.haveyourstyle.mappers.mapperImpl;

import java.util.stream.Collectors;

import be.technofutur.haveyourstyle.mappers.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.BrandDto;
import be.technofutur.haveyourstyle.models.entities.Brand;
import be.technofutur.haveyourstyle.models.forms.BrandForm;
import be.technofutur.haveyourstyle.repositories.SellerRepository;

public class BrandMapperImpl implements BaseMapper<BrandDto,BrandForm,Brand> {
    private final BrandCollectionMapperImpl brandCollectionMapper;
    private final SellerRepository sellerRepository;
    private final CommentMapperImpl commentMapper;




    public BrandMapperImpl(BrandCollectionMapperImpl brandCollectionMapper, SellerRepository sellerRepository,
            CommentMapperImpl commentMapper) {
        this.brandCollectionMapper = brandCollectionMapper;
        this.sellerRepository = sellerRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public BrandDto entityToDto(Brand entity) {
        if(entity != null){
            return BrandDto.builder()
                           .IdSeller(entity.getSeller().getUserId())
                           .brandId(entity.getBrandId())
                           .label(entity.getLabel())
                           .logo(entity.getLogo())
                           .comments(entity.getComments().stream().map(commentMapper::entityToDto).collect(Collectors.toList()))
                           .brandCollections(entity.getBrandCollections()
                                                   .stream()
                                                   .map(brandCollectionMapper::entityToDto)
                                                   .collect(Collectors.toList()))
                           .build();
        }
        return null;
    }

    @Override
    public Brand formToEntity(BrandForm form) {
        if(form != null){
            Brand b = new Brand();
            b.setBrandCollections(form.getBranCollections().stream()
                                      .map(brandCollectionMapper::formToEntity)
                                      .collect(Collectors.toList()));
            b.setLabel(form.getLabel());
            b.setLogo(form.getLogo());
            b.setSeller(sellerRepository.getById(form.getIdSeller()));
        }
        return null;
    }

    @Override
    public Brand dtoToEntity(BrandDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
