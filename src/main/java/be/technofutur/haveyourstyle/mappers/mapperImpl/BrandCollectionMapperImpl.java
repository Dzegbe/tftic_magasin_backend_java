package be.technofutur.haveyourstyle.mappers.mapperImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.BrandCollectionDto;
import be.technofutur.haveyourstyle.models.entities.BrandCollection;
import be.technofutur.haveyourstyle.models.forms.BrandCollectionForm;
import be.technofutur.haveyourstyle.repositories.ArticleRepository;
@Service
public class BrandCollectionMapperImpl implements BaseMapper<BrandCollectionDto,BrandCollectionForm,BrandCollection>{
    private final ArticleMapperImpl articleMapper;
    private final ArticleRepository articleRepository;

  

    public BrandCollectionMapperImpl(ArticleMapperImpl articleMapper, ArticleRepository articleRepository) {
        this.articleMapper = articleMapper;
        this.articleRepository = articleRepository;
    }

    @Override
    public BrandCollectionDto entityToDto(BrandCollection entity) {
        if(entity != null){
            return BrandCollectionDto.builder()
                                     .label(entity.getLabel())
                                     .logo(entity.getLogo())
                                     .brandCollectionId(entity.getBrandCollectionId())
                                     .articles(entity.getArticles().stream().map(articleMapper::entityToDto).collect(Collectors.toList()))
                                     .build();
        }
        return null;
    }

    @Override
    public BrandCollection formToEntity(BrandCollectionForm form) {
        if(form != null){
            BrandCollection bd = new BrandCollection();
            bd.setArticles(form.getArticles().stream().map(articleRepository::getById).collect(Collectors.toList()));
            bd.setLabel(form.getLabel());
            bd.setLogo(form.getLogo());
            return bd;
        }
        return null;
    }

    @Override
    public BrandCollection dtoToEntity(BrandCollectionDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
