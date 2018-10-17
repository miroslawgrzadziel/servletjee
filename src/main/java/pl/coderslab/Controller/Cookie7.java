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

@WebServlet(name = "Cookie7", urlPatterns = "/rememberMe")
public class Cookie7 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        Writer wr = response.getWriter();

        String username = request.getParameter("username");

        if(username != null) // po wyslaniu formularza sprawdzam czy jest ustawiony user name
        {
            wr.append("<h1>Cześć " + username + "</h1>"); // i wyswietlam
        }

        if(request.getParameter("remember") != null) // ustawiam ciacho jak bylo zaznaczone pole
        {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        Cookie usernameCookie = CookieService.getCookie(request, "username");

        if(usernameCookie == null) // jak nie ma ciasteczka to wywalam formularz
        {   wr.append("Wszedlem");
            wr.append("<form method='post'>");
            wr.append("<input type='text' name='username' placeholder='Nazwa uzytkownika'><br>");
            wr.append("<label><input type=\"checkbox\" name=\"remember\"> zapamiętaj mnie</label><br>");
            wr.append("<input type='submit'>");
        }
        else // inaczej dane z ciacha
        {
            wr.append("<h1>Cześć " + usernameCookie.getValue() + "!<sub style='font-size: 20px;'>Twoje dane zostały wczytane z ciasteczka</sub></h1>");
        }


    }
}
////Zadanie 6
////
////W projekcie stwórz servlet `Cookie7`, dostępny pod adresem `/rememberMe`. Następnie:
////1. W servlecie utwórz formularz, zawierający pole `name` oraz checkbox z labelem `Zapamiętaj mnie`.
//// Formularz powinien przesyłać dane metodą POST na ten sam adres.
////2. Dopisz obsługę metody POST w servlecie. Servlet powinien wyświetlić komunikat `Cześć {imię przesłane w formularzu}`.
//// W przypadku zaznaczenia checkboxa, imię użytkownika zapamiętaj w ciasteczku.
////3. Dodaj funkcjonalność, która w przypadku wejścia na stronę metodą GET sprawdzi czy istnieje odpowiednie ciasteczko.
//// Jeżeli tak, to nie wyświetlaj formularza do logowania tylko wyświetl komunikat `Cześć {imię przesłane w formularzu}. Twoje dane zostały wczytane z ciasteczka`