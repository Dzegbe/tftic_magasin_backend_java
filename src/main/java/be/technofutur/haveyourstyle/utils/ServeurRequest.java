package be.technofutur.haveyourstyle.utils;

import javax.servlet.http.HttpServletRequest;

public class ServeurRequest {
    public static String getURL(HttpServletRequest request){
        String url = request.getRequestURI().toString();
        return url.replace(request.getServletPath(), "");
    }
}
