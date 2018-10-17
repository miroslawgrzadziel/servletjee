package pl.coderslab.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieService {

    public static Cookie getCookie(HttpServletRequest request, String cookieName){

        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName))
                    return c;
            }
        }catch (Exception e){}

        return null;
    }
}
