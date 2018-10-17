package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get61", urlPatterns = {"/Get61"})
public class Get61 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        for (int i = 1980; i <= 2010; i++){
            wr.append("<p>"+"<a href='http://localhost:8080/Get62?year="+i+"\'> Link do roku "+i+"</a></p>");

        }

    }
}
//Pierwszy Get61, powinien generować linki do drugiego Get62, przekazując metodą GET dane pod kluczem year (od 1980 do 2010).
