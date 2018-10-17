package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post5", urlPatterns = {"/Post5"})
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        String conversionType = request.getParameter("convertionType");
        try {
            double degrees = Double.parseDouble(request.getParameter("degrees"));

            if (conversionType.equals("celcToFahr")) {
                wr.append("<h3>" + degrees + " stopni Celsjusza to: " + (32.0 + (9.0 * degrees) / (5.0)) + " stopni Fahrenheita.</h3>");
            }
            if (conversionType.equals("fahrToCelc")) {
                wr.append("<h3>" + degrees + " stopni Fahrenheita to: " + ((5.0 * (degrees - 32.0)) / (9.0)) + " stopni Celsjusza.</h3>");
            }
        }catch (Exception e){
            wr.append("Wprowadź wartość liczbową.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<a href='/index_5.html'>Formularz</a>");
    }
}
//Zadanie 5
//W projekcie stwórz servlet Post5 oraz stronę HTML index_5.html. Następnie:
//
//Do strony dodaj formularz zawierający jedno pole liczbowe oraz dwa przyciski submit. Każdy z przycisków niech ma inny atrybut name mówiący o sposobie konwersji.
//Po wysłaniu odpowiednich danych servlet ma przeliczać temperaturę w stopniach Celsjusza na temperaturę w stopniach Fahrenheita (i w drugą stronę). Który przycisk został kliknięty przez użytkownika dowiesz się po wartości pola convertionType przesyłanego POST-em.
//Skorzystaj z poniższego formularza:
//
//<form action="" method="POST">
//    <label>
//        Temperatura:
//        <input type="number" min="0.00" step="0.01" name="degrees">
//    </label>
//    <input type="submit" name="convertionType" value="celcToFahr">
//    <input type="submit" name="convertionType" value="FahrToCelc">
//</form>
//Aby przeliczyć jednostki użyj wzorów znajdujących się tutaj.