package be.technofutur.haveyourstyle.configs.mailConfigs;

public class MailContent {
    public static final String CONTENT_VERIFICATION_MAIL =
        "Dear [[name]],<br>"
        + "Please click the link below to verify your registration:<br>"
        + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
        + "Thank you,<br>"
        + "Your company name.";
    
}
