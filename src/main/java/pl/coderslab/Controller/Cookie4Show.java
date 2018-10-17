package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie4Show", urlPatterns = {"/Cookie4Show"})
public class Cookie4Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                wr.append("Cookie name: "+c.getName()+ ", value: " +c.getValue()+"<a href='/Cookie4Del?name="+c.getName()+"'>       Delete this one</a><br>");

            }
        }catch (Exception e){}


    }
}
//Zadanie 4
//W projekcie stwórz servlet Cookie4Show i Cookie4Del. Następnie:
//
//W servlecie Cookie4Show wyświetl wszystkie ciasteczka.
//Przy każdym z nich wygeneruj link do drugiego servletu Cookie4Del. Pamiętaj o przekazaniu w danych GET nazwy tego ciasteczka.