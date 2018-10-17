package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get2", urlPatterns = {"/Get2"})
public class Get2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        Map<String, String[]> params = request.getParameterMap();

        Set<String> paramKeys = params.keySet();
        for(String paramName : paramKeys){
            wr.append("<h2>"+paramName+"</h2>");
            wr.append("<ul>");
            for(String value : params.get(paramName)){
                wr.append("<li>"+value+"</li>");
            }
            wr.append("</ul>");
        }
    }
}
//Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Get2, który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość (niezależnie od liczby przesłanych parametrów).