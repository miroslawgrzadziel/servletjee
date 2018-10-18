package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess03_Add", urlPatterns = {"/addToSession"})
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String key = request.getParameter("key"); // pobieram wartości które wysłałem z doGet, od razu do Stringów
        String value = request.getParameter("value");

        HttpSession session = request.getSession();
        session.setAttribute(key, value);

        List<String> sessionKeys = (List<String>)session.getAttribute("keys");// chcę pobrać z sesji liste kluczy

        //jeśli lista nie istenieje w sesji to ją tworzymy
        if(sessionKeys == null)
            sessionKeys = new ArrayList<>();

        sessionKeys.add(key);//skoro na pewno lista istnieje to dodaje wartość
        session.setAttribute("keys", sessionKeys); //ustawiam zmodyfikowaną listę w sesji pod atrybutem, który wyznaczyłem powyżej "keys"


        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Writer wr = response.getWriter();

        wr.append("<form action=\"#\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");
    }
}
//Zadanie 3.
//W projekcie stwórz Sess03_Add dostępny pod adresem /addToSession oraz servlet Sess03_All dostępny pod adresem /showAllSession. Następnie:
//
//Dodaj do servletu Sess03_Add do niego następujący formularz:
//<form action="#" method="POST">
//    <label>
//        Klucz:
//        <input type="text" name="key">
//    </label>
//    <label>
//        Wartość:
//        <input type="text" name="value">
//    </label>
//    <input type="submit">
//</form>
//Dodaj do servletu Sess03_Add funkcjonalność, która po zatwierdzeniu formularza metodą POST doda nową zmienną sesyjną o podanej nazwie i wartości.
//Dodaj do servletu Sess03_All funkcjonalność, która wyświetli w formie tabeli wszystkie dane znajdujące się w sesji (zarówno klucz jak i wartość). Do przechowywania kluczy wszystkich wartości w sesji użyj dodatkowej zmiennej sesyjnej, która będzie przechowywać w tablicy lub liście wszystkie klucze.