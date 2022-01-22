package be.technofutur.haveyourstyle.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.userMapperImpl.SellerMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.repositories.UserRepository;

@Service
public class SellerServiceImpl{
    private final ArticleServiceImpl articleService;
    private final UserRepository<Seller> sellerRepository;
    private final SellerMapperImpl sellerMapper;




    public SellerServiceImpl(ArticleServiceImpl articleService, UserRepository<Seller> sellerRepository,
            SellerMapperImpl sellerMapper) {
        this.articleService = articleService;
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    public List<ArticleDto> getArticle(Long id){
        return this.articleService.getAllPerSeller(id);
    }

    

    
    
}
