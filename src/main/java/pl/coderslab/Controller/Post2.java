package pl.coderslab.Controller;

import pl.coderslab.Service.CensureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post2", urlPatterns = {"/Post2"})
public class Post2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        String text = request.getParameter("text");
        String accept = request.getParameter("accept");

        if (accept == null){
            text = CensureService.censure(text);
        }

        wr.append(text);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<a href='/index_2.html'>Formularz</a>");
    }
}
//Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Post2, oraz stronę HTML index_2.html. Następnie:
//
//Dodaj do strony formularz, wysyłany metodą POST. Formularz powinien zawierać jedno pole tekstowe i jeden checkbox z opisem Jestem świadomy konsekwencji.
//Dopisz funkcjonalność, która po przesłaniu formularza sprawdzi, czy wpisany przez użytkownika tekst zawiera wulgaryzmy. Jeżeli tak, to nasz kod powinien zastąpić wulgarne słowo znakami. ****
//Na przykład frazę cholera, znowu ta JAVA powinien zastąpić frazą *******, znów ta JAVA. Jeżeli użytkownik zaznaczy checkbox Jestem świadomy konsekwencji, to program nie sprawdzi wulgaryzmów i wyświetli wpisany tekst. Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.
//
//Hint: listę wulgaryzmów możesz stworzyć samodzielnie w postaci tablicy, lub poszukać gotowych tablic w internecie.