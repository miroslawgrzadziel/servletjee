package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get63", urlPatterns = {"/Get63"})
public class Get63 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        int year = Integer.parseInt(request.getParameter("year"));
        int mix = Integer.parseInt(request.getParameter("mix"));

        wr.append("Rok to: "+ (year+mix));

    }
}
//Trzeci Get63 ma pobrać dane z GET62 odnośnie roku i wartości mix i wyświetlić rok zmodyfikowany o tyle lat ile przesłano w mix.