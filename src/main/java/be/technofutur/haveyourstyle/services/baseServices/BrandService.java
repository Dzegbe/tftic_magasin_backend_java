package be.technofutur.haveyourstyle.services.baseServices;

import java.util.List;

import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.dtos.BrandDto;
import be.technofutur.haveyourstyle.models.forms.BrandForm;

public interface BrandService {
    
    public List<BrandDto> getAll();
    public List<ArticleDto> getArticle(Long id);
    public List<BrandDto> getPerSeller(Long id);
    public BrandDto getOne(Long id);
    public BrandDto insert(BrandForm form);
    public BrandDto update (Long id , BrandForm form);
    public String delete (Long id);


}
