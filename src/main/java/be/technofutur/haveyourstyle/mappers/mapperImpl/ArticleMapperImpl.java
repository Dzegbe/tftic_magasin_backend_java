package be.technofutur.haveyourstyle.mappers.mapperImpl;

import be.technofutur.haveyourstyle.mappers.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.entities.Article;
import be.technofutur.haveyourstyle.models.forms.ArticleForm;
import be.technofutur.haveyourstyle.repositories.BrandRepository;

public class ArticleMapperImpl implements BaseMapper<ArticleDto,ArticleForm,Article> {

    private final BrandRepository bRepository;

    

    public ArticleMapperImpl(BrandRepository bRepository) {
        this.bRepository = bRepository;
    }

    @Override
    public ArticleDto entityToDto(Article entity) {
        if(entity != null){
            return ArticleDto.builder()
                             .articleId(entity.getArticleId())
                             .brand(entity.getBrand())
                             .info(entity.getInfo())
                             .label(entity.getLabel())
                             //conversion a faire
                             .pictures(entity.getPictures())
                             .price(entity.getPrice())
                             .build();
        }
        return null;
    }

    @Override
    public Article formToEntity(ArticleForm form) {
        if(form != null && bRepository.existsById(form.getIdBrand())){
            Article a = new Article();
            a.setBrand(bRepository.getById(form.getIdBrand()));
            //a.getInfo besoin du mapper de info
            a.setCanModifie(form.isCanModifie());
            a.setLabel(form.getLabel());
            a.setMaxQuantity(form.getMaxQuantity());
            // pas encore la reponse a.setPictures(form.get);
            a.setPrice(form.getPrice());
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
