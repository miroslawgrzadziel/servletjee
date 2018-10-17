package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie4Del", urlPatterns = {"/Cookie4Del"})
public class Cookie4Del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        String cookieName = request.getParameter("name"); //pobieram nazwę ciasteczka do usunięcia z adresu przekazanego z Cooke4Show

        Cookie cookie = new Cookie(cookieName,""); //żeby usunąć, tworzę nowe ciesteczko o tej samej nazwie
        cookie.setMaxAge(0);//żywotność ustawiam na zero, zostanie usunięte przy następnym sprawdzeniu
        response.addCookie(cookie);

        wr.append("Ciasteczko "+cookieName+" zostało usunięte");

        response.getWriter().append("<br><br><a href='Cookie4Show'>Przejdź do listy ciasteczek.</a>");
    }
}
//W servlecie Cookie4Del usuń ciasteczko i poinformuj o tym.