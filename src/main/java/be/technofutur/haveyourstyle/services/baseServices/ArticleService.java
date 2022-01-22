package be.technofutur.haveyourstyle.services.baseServices;

import java.util.List;

import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.forms.ArticleForm;

public interface ArticleService {
    public ArticleDto getOne(Long id);
    public List<ArticleDto> getAll();
    public List<ArticleDto> getAllPerBrands(Long id );
    public List<ArticleDto> getAllPerSeller(Long id);
    public String delete (Long id);
    public ArticleDto update(Long id,ArticleForm form);
    public ArticleDto insert(ArticleForm form);
    
}
