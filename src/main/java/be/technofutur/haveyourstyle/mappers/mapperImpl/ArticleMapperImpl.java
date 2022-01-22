package be.technofutur.haveyourstyle.mappers.mapperImpl;



import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.entities.Article;
import be.technofutur.haveyourstyle.models.forms.ArticleForm;
import be.technofutur.haveyourstyle.repositories.BrandRepository;
@Service
public class ArticleMapperImpl implements BaseMapper<ArticleDto,ArticleForm,Article> {

    private final BrandRepository bRepository;
    private final BrandMapperImpl mapper;

    

    public ArticleMapperImpl(BrandRepository bRepository, BrandMapperImpl mapper) {
        this.bRepository = bRepository;
        this.mapper = mapper;
    }

    @Override
    public ArticleDto entityToDto(Article entity) {
        if(entity != null){
            ArticleDto dto = ArticleDto.builder()
                             .id(entity.getArticleId())
                             .brand(mapper.entityToDto(entity.getBrand()))
                            //  .info(entity.getInfo())
                             .label(entity.getLabel())
                             //conversion a faire
                             .price(entity.getPrice())
                             .build();
            if(entity.getPictures() != null){
                dto.setPictures(entity.getPictures());
            }
            return dto;
        }
        return null;
    }

    @Override
    public Article formToEntity(ArticleForm form, Article  a) {
        if(form != null ){
            //a.getInfo besoin du mapper de info
            //a.setCanModifie(form.isCanModifie());
            a.setLabel(form.getLabel());
            //a.setMaxQuantity(form.getMaxQuantity());
            a.setPictures(form.getPictures());
            a.setPrice(form.getPrice());
            if(bRepository.existsById(form.getIdBrand())){
                a.setBrand(bRepository.getById(form.getIdBrand()));
            }
            return a;
        }
        return null;
    }

    @Override
    public Article dtoToEntity(ArticleDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
