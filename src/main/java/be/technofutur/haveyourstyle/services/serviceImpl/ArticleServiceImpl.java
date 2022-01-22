package be.technofutur.haveyourstyle.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.mapperImpl.ArticleMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.entities.Article;
import be.technofutur.haveyourstyle.models.forms.ArticleForm;
import be.technofutur.haveyourstyle.repositories.ArticleRepository;
import be.technofutur.haveyourstyle.services.baseServices.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapperImpl articleMapper;
    private final ArticleRepository articleRepository;

    

    public ArticleServiceImpl(ArticleMapperImpl articleMapper, ArticleRepository articleRepository) {
        this.articleMapper = articleMapper;
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto getOne(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("this article doesn't exist"));
        return articleMapper.entityToDto(article);
    }

    @Override
    public String delete(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("this article doesn't exist"));
        articleRepository.delete(article);
        return "l'article "+ article.getLabel() +" has deleted";
    }

    @Override
    public ArticleDto update(Long id, ArticleForm form) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("this article doesn't exist"));
        article = articleMapper.formToEntity(form,article);
        return articleMapper.entityToDto((articleRepository.save(article)));
    }

   
    @Override
    public List<ArticleDto> getAll() {
        return articleRepository.findAll().stream().map(articleMapper :: entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticleDto insert(ArticleForm form) {
        Article art = new Article();
       art = articleMapper.formToEntity(form,art);
       return articleMapper.entityToDto((articleRepository.save(art)));
    }

    @Override
    public List<ArticleDto> getAllPerBrands(Long id) {
        return articleRepository.findAll().stream().filter((art)-> art.getBrand().getBrandId() == id)
                                    .map(articleMapper :: entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> getAllPerSeller(Long id) {
        return articleRepository.findAll().stream().filter((art)-> art.getBrand().getSeller().getUserId() == id)
                                    .map(articleMapper :: entityToDto).collect(Collectors.toList());
    }
     
    
    
}
