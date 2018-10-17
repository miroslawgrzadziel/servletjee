package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie51", urlPatterns = "/Cookie51")
public class Cookie51 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        Cookie cookie = new Cookie("visited", "true");
        cookie.setMaxAge(1 * 60 * 60);
        response.addCookie(cookie);

        String msg = request.getParameter("msg");
        if(msg!=null)
        {
            wr.append(msg+" ");
        }
        wr.append("<a href='/Cookie52'>Teraz możesz wejść!</a>");
    }
}
//Zadanie 5
//W projekcie stwórz dwa servlety Cookie51 i Cookie52. Następnie:
//
//Wymagamy aby użytkownik najpierw odwiedził stronę wygenerowaną przez servlet Cookie51, a dopiero potem mógł przejść do strony wygenerowanej przez Cookie52.
//Gdy użytkownik wejdzie na pierwszą stronę, zapisz odpowiednią informację w ciasteczku oraz wygeneruj link do drugiego servletu.
//Przy wejściu na stronę wygenerowaną przez servlet Cookie52 sprawdź czy dane ciasteczko istnieje:
//Jeżeli istnieje to je usuń oraz wypisz komunikat Witamy na stronie Cookie52
//jeżeli ciasteczka nie ma przekieruj użytkownika przy użyciu metody sendRedirect na adres servletu Cookie51 przekazując jednocześnie parametr o nazwie msg o wartości: Nie odwiedziłeś jeszcze tej strony.
//Hint: Przetestuj servlety w różnych przeglądarkach, manualnie usuwając ciasteczka (możesz to zrobić w konsoli deweloperskiej).
//
//Dla przekierowania wykorzystaj poniższy kod:
//
//String message = "Nie odwiedziles jeszcze tej strony"; response.sendRedirect("Cookie51?msg=" + URLEncoder.encode(message));