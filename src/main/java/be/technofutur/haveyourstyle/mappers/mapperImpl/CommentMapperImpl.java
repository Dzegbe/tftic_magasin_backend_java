package be.technofutur.haveyourstyle.mappers.mapperImpl;



import be.technofutur.haveyourstyle.mappers.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.CommentDto;
import be.technofutur.haveyourstyle.models.entities.Comment;
import be.technofutur.haveyourstyle.models.forms.CommentForm;
import be.technofutur.haveyourstyle.repositories.CustomerRepository;

public class CommentMapperImpl implements BaseMapper<CommentDto,CommentForm,Comment> {
    private final CustomerRepository customerRepository;

    

    public CommentMapperImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CommentDto entityToDto(Comment entity) {
        if(entity != null && customerRepository.existsById(entity.getIdCustomer())){
            return CommentDto.builder()
                             .comment(entity.getCommentMessage())
                             .customerId(entity.getIdCustomer())
                             .sellerAnswer(entity.getSellerAnswer())
                             .date(entity.getDate())
                             .customerName(customerRepository.getById(entity.getIdCustomer()).getName())
                             .customerUrname(customerRepository.getById(entity.getIdCustomer()).getSurname())
                             .build();
        }
        return null;
    }

    @Override
    public Comment formToEntity(CommentForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comment dtoToEntity(CommentDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
