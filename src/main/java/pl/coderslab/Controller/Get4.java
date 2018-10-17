package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get4", urlPatterns = {"/Get4"})
public class Get4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            wr.append("Została przesłana wartość: "+ page + "<br>");
            wr.append("Dzielniki całkowite przesłanej liczby: ");
            for (int i = 1; i <= page; i++){
                if (page%i == 0){
                    wr.append(i+", ");
                }
            }

        }catch (Exception e){
            wr.append("Proszę podać liczbę całkowitą.");
        }
    }
}
//Zadanie 4
//W projekcie stwórz servlet Get4, dostępny pod adresem /Get4, oraz stronę HTML index.html, w której zawarty jest formularz przesyłany metodą GET z jednym polem page.
//Po uruchomieniu aplikacji na serwerze, uzupełnieniu i zatwierdzeniu formularza w przeglądarce wyświetli się informacja czy wartość została przesłana oraz wyświetlone zostaną dzielniki całkowite przesłanej liczby.