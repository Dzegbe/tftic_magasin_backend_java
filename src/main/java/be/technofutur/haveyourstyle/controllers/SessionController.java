package be.technofutur.haveyourstyle.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.technofutur.haveyourstyle.models.dtos.CustomerDto;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.dtos.UserDto;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.UserFormLogin;
import be.technofutur.haveyourstyle.services.serviceImpl.SessionServiceImpl;

@RestController
public class SessionController {

    private final SessionServiceImpl sessionService;

    public SessionController(SessionServiceImpl sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserFormLogin form ){
        return ResponseEntity.ok(this.sessionService.login(form));
    }

    @PostMapping("/registerCustomer")
    public ResponseEntity<CustomerDto> registerCustomer(@Valid @RequestBody CustomerRegisterForm form){
        return ResponseEntity.ok(this.sessionService.registerCustomer(form));
    }

    @PostMapping("/registerSellerInd")
    public ResponseEntity<IndividualSellerDto> registerSellerInd(@Valid @RequestBody IndividualSellerRegisterForm form){
        return ResponseEntity.ok(this.sessionService.registerSellerind(form));
    }

    @PostMapping("/registerSellerPro")
    public ResponseEntity<ProfessionalSellerDto> registerSellerPro(@Valid @RequestBody ProSellerRegisterForm form){
        return ResponseEntity.ok(this.sessionService.registerSellerPro(form));
    }
    
}
