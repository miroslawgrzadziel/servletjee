package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post1", urlPatterns = {"/Post1"})
public class Post1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        response.getWriter().append("Witaj, "+name+" "+surname);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<a href='/index_1.html'>Formularz</a>");
    }
}
//Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Post1 oraz stronę HTML index_1.html, w której zawarty jest formularz przesyłający imię i nazwisko. Po uruchomieniu na serwerze i uzupełnieniu formularza w przeglądarce wyświetli się napis: Witaj, <podane imię> <podane nazwisko>.