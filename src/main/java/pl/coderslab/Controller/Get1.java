package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get1", urlPatterns = {"/Get1"})
public class Get1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        try {
            int start = Integer.parseInt(request.getParameter("start")); // od razu chcemy sparsować przesłane dane do int
            int end = Integer.parseInt(request.getParameter("end"));

            for(int i =start; i <= end; i++){
                wr.append(i+", ");
            }

        }catch (Exception e){
            wr.append("Brak przesłanych danych"); // wykorzystujemy exeption do zapewnienia komunikatu o błędnych danych wprowadzonych przez użytkownika
        }

    }
}

//w przeglądarce wpisujemy przykładowo http://localhost:8080/Get1?start=10&end=20

//Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Get1, który wczyta dwie zmienne: start i end .
//Po uruchomieniu aplikacji na serwerze, w przeglądarce wyświetlą się wszystkie liczby od start do end. (dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite). Jeżeli zmienne nie są przesłane, to strona ma wypisać informację 'Brak przesłanych zmiennych'.
