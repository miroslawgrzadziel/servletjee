package pl.coderslab.Controller;

import pl.coderslab.Service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "Cookie52", urlPatterns = "/Cookie52")
public class Cookie52 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie visitedC = CookieService.getCookie(request, "visited");
        if(visitedC != null)
        {
            if(visitedC.getValue().equals("true"))
            {
                response.getWriter().append("Witamy na stronie 52");
            }
            visitedC.setMaxAge(0);
            response.addCookie(visitedC);
        }
        else
        {
            String message = "Nie odwiedziles jeszcze tej strony";
            response.sendRedirect("Cookie51?msg=" + URLEncoder.encode(message));
        }
    }
}
