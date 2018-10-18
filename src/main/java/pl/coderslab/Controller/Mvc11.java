package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc11", urlPatterns = {"/Mvc11"})
public class Mvc11 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String role = request.getParameter("role");

        request.setAttribute("role", role);

        getServletContext().getRequestDispatcher("/WEB-INF/views/jsp1.jsp").forward(request,response); //podajemy ścieżke względem katalogu webapp
    }
}
//Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz stronę jsp1.jsp. Następnie:
//
//Dołącz do projektu biblioteki jstl
//W projekcie stwórz servlet Mvc11 dostępny pod adresem /Mvc11
//W servlecie pobierz wartość GET o nazwie role a następnie ustaw atrybut o nazwie role.
//Ustaw plik jsp jako plik widoku dla tego servletu.
//W przypadku braku wartości ma się wyświetlić napis guest.