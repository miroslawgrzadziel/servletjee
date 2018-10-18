package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Sess01Get", urlPatterns = {"/Sess01Get"})
public class Sess01Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter"); //musimy zrzutować do typu INTEGER bo w sesji zrzuca do najbardziej ogólnego typu czyli OBJECT

        if(counter == null){
            response.getWriter().append("No counter in session.");
        }else{
            counter++;
            session.setAttribute("counter", counter);
            response.getWriter().append(counter.toString()); //trzeba z powrotem przemienić na STRINGA
        }
    }
}
//Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać ją o 1. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić odpowiednią informację.
