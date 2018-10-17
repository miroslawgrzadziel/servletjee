package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = {"/Get62"})
public class Get62 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        Random r = new Random();
        String year = request.getParameter("year");

        for (int i = 1; i <= 5; i++){
            int a = r.nextInt(6)-5;
            wr.append("<p><a href='http://localhost:8080/Get63?year="+year+"&mix="+a+"\'> Rok"+year+", mix "+a+"</a></p>");
        }



    }
}
//Drugi Get62 powinien odebrać przesłane poprzez GET dane z pierwszego Get61 i wygenerować 5 linków, gdzie każdy z nich ma przenosić do trzeciego Get63 przekazując metodą GET następujące dane:
//year - dane przesłane z poprzedniej strony
//mix - losowa wartość z zakresu od -10 do 10