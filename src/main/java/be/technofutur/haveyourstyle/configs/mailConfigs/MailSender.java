package be.technofutur.haveyourstyle.configs.mailConfigs;



import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.User;

public class MailSender{
    @Bean
    public static JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(MailConst.HOST);
        mailSender.setPort(MailConst.PORT);

        mailSender.setUsername(MailConst.MAIL_ADRESS);
        mailSender.setPassword(MailConst.PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.debug","true");

        return mailSender;
    }

    public static void sendMail(String mail,String content,String subject) 
        throws MessagingException,UnsupportedEncodingException{
       
            String toAdress = mail;
            String fromAdress = MailConst.MAIL_ADRESS;
            String sender = "haveYourStyle";
    
            MimeMessage message = MailSender.getJavaMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            
            //modifie l'adress de l'emmeteur de l'email et son nom
            helper.setFrom(fromAdress,sender);
            //modifie l'adress du destinataire
            helper.setTo(toAdress);
            //modifie le sujet du mail
            helper.setSubject(subject);
            //pour signifier que le mail est  ecis sous des forme differente ici integration html
            helper.setText(content, true);

            MailSender.getJavaMailSender().send(message);
    }   
}
