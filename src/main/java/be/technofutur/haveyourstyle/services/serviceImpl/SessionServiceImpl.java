package be.technofutur.haveyourstyle.services.serviceImpl;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.configs.securityConfigs.jwtToken.JwtTokenProvider;
import be.technofutur.haveyourstyle.mappers.userMapperImpl.CustomerMapperImpl;
import be.technofutur.haveyourstyle.mappers.userMapperImpl.SellerMapperImpl;
import be.technofutur.haveyourstyle.mappers.userMapperImpl.UserRegisterMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.CustomerDto;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.dtos.UserDto;
import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.entities.User;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.UserFormLogin;
import be.technofutur.haveyourstyle.repositories.UserRepository;
import be.technofutur.haveyourstyle.services.baseServices.SessionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {
    private final UserRepository<Seller> sRepository;
    private final UserRepository<Customer> cRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider provider;
    private final UserRegisterMapperImpl mRegisterMapper;
    private final SellerMapperImpl sellerMapper;
    private final CustomerMapperImpl customerMapper;
    private AuthenticationManager manager;


    public SessionServiceImpl(UserRepository<Seller> sRepository, UserRepository<Customer> cRepository,
            PasswordEncoder encoder, JwtTokenProvider provider, UserRegisterMapperImpl mRegisterMapper,
            SellerMapperImpl sellerMapper, CustomerMapperImpl customerMapper, AuthenticationManager manager) {
        this.sRepository = sRepository;
        this.cRepository = cRepository;
        this.encoder = encoder;
        this.provider = provider;
        this.mRegisterMapper = mRegisterMapper;
        this.sellerMapper = sellerMapper;
        this.customerMapper = customerMapper;
        this.manager = manager;
    }

    @Override
    public UserDto login(UserFormLogin formLogin) {
        try{
            User u = getUsername(formLogin.getUsername());

            manager.authenticate(new UsernamePasswordAuthenticationToken(formLogin.getUsername(), formLogin.getPassword()));

            UserDto uDto = getUserDto(u);

            uDto.setToken(provider.createToken(u));

            return uDto;
        }
        catch(Exception e){
            throw new IllegalArgumentException("this user : "+formLogin.getUsername()+" doesn't exist");
        }

    }

    @Override
    public IndividualSellerDto registerSellerind(IndividualSellerRegisterForm formRegisterInd) {
        Seller s = mRegisterMapper.formToEntityIndividual(formRegisterInd);
        if(s != null){
            s.setAccountNonExpired(true);
            s.setAccountNonLocked(true);
            s.setCredentialsNonExpired(true);
            s.setEnabled(true);
            s.setPassword(encoder.encode(formRegisterInd.getPassword()));
            s.setRoles(List.of("USER","SELLER"));
            s.setFunctionSeller("INDIVIDUAL");
            s.setUsername("S"+formRegisterInd.getEmail());
            
            
            IndividualSellerDto dto = sellerMapper.entityToDtoIndividual(sRepository.save(s));
            dto.setToken(provider.createToken(s));

            return dto;
        }
        return null;
    }

    @Override
    public ProfessionalSellerDto registerSellerPro(ProSellerRegisterForm formRegisterPro) {
        Seller s = mRegisterMapper.formToEntityPrfessional(formRegisterPro);
        if(s != null){
            s.setAccountNonExpired(true);
            s.setAccountNonLocked(true);
            s.setCredentialsNonExpired(true);
            s.setEnabled(true);
            s.setPassword(encoder.encode(formRegisterPro.getPassword()));
            s.setRoles(List.of("USER","SELLER"));
            s.setFunctionSeller("PROFESSIONAL");
            s.setUsername("S"+formRegisterPro.getEmail());

            ProfessionalSellerDto dto = sellerMapper.entityToDtoProfessional(sRepository.save(s));
            dto.setToken(provider.createToken(s));

            return dto;
        }
        return null;
    }

    @Override
    public CustomerDto registerCustomer(CustomerRegisterForm formRegisterCustomer) {
        Customer c = mRegisterMapper.register(formRegisterCustomer);
        if(c != null){
            c.setAccountNonExpired(true);
            c.setAccountNonLocked(true);
            c.setCredentialsNonExpired(true);
            c.setEnabled(true); 
            c.setPassword(encoder.encode(formRegisterCustomer.getPassword()));
            c.setRoles(List.of("USER","CUSTOMER"));
            c.setUsername("C"+formRegisterCustomer.getEmail());

            CustomerDto dto = customerMapper.entityToDto(cRepository.save(c));
            dto.setToken(provider.createToken(c));

            return dto;
        }
        return null;
    }

    private User getUsername(String username){
        Seller s = sRepository.findByUsername(username).orElse(null);
        if(s == null){
            Customer c = cRepository.findByUsername(username).orElse(null);
            if(c != null)
                return c;
        }
        else
            return s;
        throw new IllegalArgumentException("l'username : "+ username +"doen't exist"); 
    }
    
    private UserDto getUserDto(User u){
        if(u.getRoles().stream().anyMatch((role)-> role.equals("CUSTOMER"))){
            return customerMapper.entityToDto((Customer) u);
        }
        else
            if(u.getRoles().stream().anyMatch((role)-> role.equals("SELLER"))){
                Seller s = (Seller) u;
                if(s.getFunctionSeller().equals("INDIVIDUAL")){
                    return sellerMapper.entityToDtoIndividual(s);
                }
                else{
                    return sellerMapper.entityToDtoProfessional(s);
                }
            }
       throw new IllegalArgumentException("username : "+u.getUsername()+"doesn't exist");
    }
}
