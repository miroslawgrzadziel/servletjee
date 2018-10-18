package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc14", urlPatterns = {"/Mvc14"})
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String title1


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/WEB-INF/views/Form.jsp").forward(request,response);

    }
}
//Zadanie 4
//W projekcie stwórz servlet Mvc14 dostępny pod adresem /Mvc14. Następnie:
//
//W widoku wyświetlanym metodą GET o nazwie form.jsp stwórz formularz zawierający pola o nazwach (title1, author1, isbn1), (title2, author2, isbn2), itd do 5. Formularz ma być przesłany metodą POST do servletu Mvc14.
//Zaimportuj wcześniej stworzoną klasę Book.
//W servlecie Mvc14 odbierz dane i na ich podstawie stwórz obiekty klasy Book.
//Obiekty umieść w liście lub tablicy, którą następnie przekaż do widoku result.jsp.
//W pętli wyświetl właściwości wszystkich obiektów title, author.