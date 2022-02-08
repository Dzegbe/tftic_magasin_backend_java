package be.technofutur.haveyourstyle.services.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.configs.mailConfigs.JwtTokenProviderMail;
import be.technofutur.haveyourstyle.configs.mailConfigs.MailConst;
import be.technofutur.haveyourstyle.configs.mailConfigs.MailContent;
import be.technofutur.haveyourstyle.configs.mailConfigs.MailSender;
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
import be.technofutur.haveyourstyle.repositories.CustomerRepository;
import be.technofutur.haveyourstyle.repositories.UserRepository;
import be.technofutur.haveyourstyle.services.baseServices.SessionService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {
    private final UserRepository<Seller> sRepository;
    private final CustomerRepository cRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider provider;
    private final JwtTokenProviderMail providerMail;
    private final UserRegisterMapperImpl mRegisterMapper;
    private final SellerMapperImpl sellerMapper;
    private final CustomerMapperImpl customerMapper;
    private AuthenticationManager manager;

    public SessionServiceImpl(UserRepository<Seller> sRepository, CustomerRepository cRepository,
            PasswordEncoder encoder, JwtTokenProvider provider, JwtTokenProviderMail providerMail,
            UserRegisterMapperImpl mRegisterMapper, SellerMapperImpl sellerMapper, CustomerMapperImpl customerMapper,
            AuthenticationManager manager) {
        this.sRepository = sRepository;
        this.cRepository = cRepository;
        this.encoder = encoder;
        this.provider = provider;
        this.providerMail = providerMail;
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
        Seller s = new Seller();
         s = mRegisterMapper.formToEntityIndividual(formRegisterInd,s);
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
        Seller s = new Seller();
        s = mRegisterMapper.formToEntityPrfessional(formRegisterPro,s);
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
    public String registerCustomer(CustomerRegisterForm formRegisterCustomer,String siteURL)
        throws UnsupportedEncodingException,MessagingException {
        Customer c = new Customer();
        c = mRegisterMapper.register(formRegisterCustomer,c);
        if(c != null){
            String verificationCode = RandomString.make(64);
            c.setAccountNonExpired(true);
            c.setAccountNonLocked(true);
            c.setCredentialsNonExpired(true);
            c.setEnabled(false);
            c.setVerificationtoken(providerMail.creatTokenMail(verificationCode));
            c.setPassword(encoder.encode(formRegisterCustomer.getPassword()));
            c.setRoles(List.of("USER","CUSTOMER"));
            c.setUsername("C"+formRegisterCustomer.getEmail());

            cRepository.save(c);

            sendVerificationMail(c,MailContent.CONTENT_VERIFICATION_MAIL,siteURL,verificationCode);

            return "verify sucess";

            // CustomerDto dto = customerMapper.entityToDto(cRepository.save(c));
            // dto.setToken(provider.createToken(c));

        }else 
             return "verify not sucess";
        
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

    private void sendVerificationMail(Customer customer,String content,String siteURL,
        String verificationMailCode)
        throws UnsupportedEncodingException,MessagingException{
        //déterminer le sujet du mail
        String subject = "verify your email adress";
        
        //creation de L'url de verification de l'adress mail
        String virificationUrl = siteURL+"/verifyCustomer?code="+ verificationMailCode+"&mail="+customer.getEmail();

        //remplacement des elements dans le content
        content = content.replace("[[name]]", customer.getName());
        content = content.replace("[[URL]]", virificationUrl);

        //envoie du mail
        MailSender.sendMail(customer.getEmail(),content, subject);
    }

    public CustomerDto verify(String verificationCode,String mail){
        Customer customer = cRepository.findByEmail(mail).orElse(null);
        if(customer != null && !customer.isEnabled() && providerMail.toCheckCode(
            customer.getVerificationtoken(), verificationCode)){
                customer.setVerificationtoken(null);
                customer.setEnabled(true);
                CustomerDto dto = customerMapper.entityToDto(cRepository.save(customer));
                dto.setToken(provider.createToken(customer));
                return dto;
            }
        else
            return null;

    }
}
