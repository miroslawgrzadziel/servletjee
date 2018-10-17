package pl.coderslab.Controller;

import pl.coderslab.Service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie1Get", urlPatterns = {"/showCookie"})
public class Cookie1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Writer wr = response.getWriter();

        Cookie cookie = CookieService.getCookie(request, "User");
            if(cookie != null){
                wr.append("Cookie value = "+cookie.getValue());
                wr.append("<a href='/deleteCookie'>Delete</a>");
            }
                wr.append("Cookie not exists");
                wr.append("<a href='/setCookie'>AddCookie</a>");
    }
}
