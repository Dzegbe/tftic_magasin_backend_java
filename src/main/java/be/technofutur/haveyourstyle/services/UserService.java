package be.technofutur.haveyourstyle.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
    private final UserRepository<Seller> sRepository;
    private final UserRepository<Customer> cRepository;
    

    public UserService(UserRepository<Seller> sRepository, UserRepository<Customer> cRepository) {
        this.sRepository = sRepository;
        this.cRepository = cRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

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
   
    
}
