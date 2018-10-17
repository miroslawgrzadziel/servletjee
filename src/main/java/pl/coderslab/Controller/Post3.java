package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post3", urlPatterns = {"/Post3"})
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        try {
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            int c = Integer.parseInt(request.getParameter("c"));
            double delta = (b*b-4*a*c);
            double pdelta = Math.sqrt(delta);
            double x1, x2, x0;
            wr.append("<h2>Dla równania kwadratowego: "+a+"x^2 + "+b+"x + "+c+"</h2>");
            if(delta>0)
            {
                x1=(-b-pdelta)/(2*a);
                x2=(-b+pdelta)/(2*a);
                wr.append("Delta wynosi: "+delta+", X1 wynosi: "+x1+", X2 wynosi: "+x2);
            }
            else if(delta==0)
            {
                x0=-b/(2*a);
                wr.append("Delta wynosi:"+delta+", X0 wynosi: "+x0);
            }
            else
            {
                wr.append("Delta jest ujemna i wynosi: "+delta+". Funkcja nie posiada miejsc zerowych");
            }

        }catch (Exception e) {
            wr.append("Podano nieprawidłowe wartości");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<a href='/index_3.html'>Formularz</a>");
    }
}
//Zadanie 3
//W projekcie stwórz servlet Post3 oraz stronę HTML index_3.html. Następnie:
//
//Napisz formularz, zawierający trzy pola liczbowe: a, b i c.
//Dopisz funkcjonalność, która po przesłaniu formularza wyliczy miejsca zerowe funkcji kwadratowej zdefiniowanej poprzez podane w formularzu liczby (ax^2+bx+c). Wyświetl wyliczone miejsca zerowe na stronie. W przypadku delta<0 servlet wyświetli odpowiedni komunikat.