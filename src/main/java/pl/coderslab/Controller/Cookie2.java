package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2", urlPatterns = {"/addToCookie"})
public class Cookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieName = request.getParameter("key").trim(); //usuwamy białe znaki przed i po
        String cookieValue = request.getParameter("value");

//musimy zwalidować czy użytkownik podał cookie name
        if(cookieName.length()>0){
            Cookie cookie = new Cookie(cookieName, cookieValue);
            response.addCookie(cookie);
        }
        response.sendRedirect("/index2.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/index2.html");
    }
}
//W projekcie stwórz servlet Cookie2, dostępny pod adresem /addToCookie, oraz plik index2.html, który wyświetli następujący formularz:
//
//<form action="" method="POST">
//    <label>
//        Klucz:
//        <input type="text" name="key">
//    </label>
//    <label>
//        Wartość:
//        <input type="text" name="value">
//    </label>
//    <input type="submit">
//
//</form>
//Po zatwierdzeniu formularza metodą POST dodajemy nowe ciasteczko o podanej nazwie i wartości.