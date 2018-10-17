package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3", urlPatterns = {"/Cookie3"})
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String cookieName = request.getParameter("key").trim(); //usuwamy białe znaki przed i po
        String cookieValue = request.getParameter("value");
        int cookieAge = Integer.parseInt(request.getParameter("lifetime"));

//musimy zwalidować czy użytkownik podał cookie name
        if(cookieName.length()>0){
            Cookie cookie = new Cookie(cookieName, cookieValue);
            cookie.setMaxAge(cookieAge*3600);
            response.addCookie(cookie);
        }
        response.sendRedirect("/index3.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
