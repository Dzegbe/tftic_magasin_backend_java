package be.technofutur.haveyourstyle.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.mapperImpl.BrandMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.dtos.BrandDto;
import be.technofutur.haveyourstyle.models.entities.Brand;
import be.technofutur.haveyourstyle.models.forms.BrandForm;
import be.technofutur.haveyourstyle.repositories.BrandRepository;
import be.technofutur.haveyourstyle.repositories.SellerRepository;
import be.technofutur.haveyourstyle.services.baseServices.BrandService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapperImpl mapper;
    private final BrandRepository repository;
    private final SellerRepository sellerRepository;
    private final ArticleServiceImpl articleService;

    

    public BrandServiceImpl(BrandMapperImpl mapper, BrandRepository repository, SellerRepository sellerRepository,
            ArticleServiceImpl articleService) {
        this.mapper = mapper;
        this.repository = repository;
        this.sellerRepository = sellerRepository;
        this.articleService = articleService;
    }

    @Override
    public List<BrandDto> getAll() {
        return repository.findAll().stream().map(mapper :: entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<BrandDto> getPerSeller(Long id) {
        if(sellerRepository.existsById(id)){
        return repository.findAll().stream().filter((brand) -> brand.getSeller().getUserId() == id)
                                    .map(mapper :: entityToDto).collect(Collectors.toList());
        }
        throw new IllegalArgumentException("this user doesn't exist");
    }

    @Override
    public BrandDto getOne(Long id) {
        Brand brand = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("this brand doesn't exist"));
        return mapper.entityToDto(brand);
    }

    @Override
    public BrandDto insert(BrandForm form) {
        Brand brand = new Brand();
       brand = mapper.formToEntity(form,brand);
       return mapper.entityToDto(repository.save(brand));
    }

    @Override
    public BrandDto update(Long id, BrandForm form) {
        Brand brand = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("this brand doesn't exist"));
        brand = mapper.formToEntity(form,brand);
        return mapper.entityToDto(repository.save(brand));
    }

    @Override
    public String delete(Long id) {
        Brand brand = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("this brand doesn't exist"));
        repository.delete(brand);
        return "the brand " + brand.getLabel() +"has deleted";
    }

    @Override
    public List<ArticleDto> getArticle(Long id) {
        return this.articleService.getAllPerSeller(id);
    }


    

    
}
