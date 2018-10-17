package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get3", urlPatterns = {"/Get3"})
public class Get3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        int width = 5;
        int height = 10;


        try {
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
        }catch (Exception e){
            wr.append("Przyjęto domyślne wartości dla width = 5 i height = 10." + "\n");
        }
        wr.append("<table>");
        for (int i = 1; i <= height; i++) {
            wr.append("<tr>");
            for (int j = 1; j <= width; j++) {
              wr.append("<td>|   " + i + " * " + j + " = " + i * j + "   |   </td>");
            }
            wr.append("</tr>");
        }
        wr.append("</table>");
    }
}
//Zadanie 3
//W projekcie stwórz servlet Get3, który ma pobierać dwie zmienne o nazwach width i height. Jeżeli informacje nie są przesłane to width = 5 i height = 10.
//Następnie wygeneruj tabliczkę mnożenia o podanej wysokości i szerokości i wyświetl ją w przeglądarce.