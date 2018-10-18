package pl.coderslab.Controller;

import pl.coderslab.Model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc13", urlPatterns = {"/Mvc13"})
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book book = new Book(author, title, isbn);

        request.setAttribute("book", book);//przekazujemy do widoku poprzez rozbudowanie requesta

        getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/WEB-INF/views/mvc13Form.jsp").forward(request,response);

    }
}
//Zadanie 3
//W projekcie stwórz servlet Mvc13 dostępny pod adresem /Mvc13. Następnie:
//
//W widoku stwórz formularz zawierający pola o nazwach (title, author, isbn). Formularz ma przesłać dane metodą POST do tego samego servletu (do metody doPost).
//Stwórz klasę Book zawierającą pola zgodne z polami wcześniej utworzonego formularza.
//Odbierz dane i na ich podstawie stwórz obiekt klasy Book.
//Przekaż obiekt do widoku result.jsp.
//Wyświetl właściwości nowo dodanego obiektu: title, author.