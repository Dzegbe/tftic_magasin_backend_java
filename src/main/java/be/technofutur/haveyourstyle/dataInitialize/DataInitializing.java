package be.technofutur.haveyourstyle.dataInitialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import be.technofutur.haveyourstyle.models.entities.Adress;
import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class DataInitializing implements InitializingBean {
    private final CustomerRepository customerRepository;


    public DataInitializing(CustomerRepository customerRepository ) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>> !! INITIALIZE DATABASE !! <<<");


       Adress adress =  Adress.builder()
                                .city("city")
                                .country("country")
                                .houseNumber(3)
                                .street("street")
                                .zipCode(6000)
                                .function(List.of("LIVRAISON"))
                                .build();
        
        Customer customer = 
            Customer.builder()
                    .adress(List.of(adress))
                    .email("joey@gmail.com")
                    .gsmNumber("0488563456")
                    .name("bruce")
                    .password("jojo")
                    .surname("brodouile")
                    .roles(List.of("User"))
                    .telNumber(null)
                    .username("costume")
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
        
        customerRepository.save(customer);
         
    }

    
    
}
