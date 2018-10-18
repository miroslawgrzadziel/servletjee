package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "Sess03_All", urlPatterns = {"/showAllSession"})
public class Sess03_All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Writer wr = response.getWriter();

        HttpSession session = request.getSession();//pobieram sesję
        List<String> sessionAttributeNames = (List<String>)session.getAttribute("keys");//pobieram listę kluczy

        //sprawdzam czy lista nie jest pusta
        if(sessionAttributeNames != null){

            wr.append("<ul>");
            for(String name : sessionAttributeNames){//pętla po kluczach w celu odczytu danych z listy, bo wiem że to są Stringi, stworzone wcześniej jako osobna zmienna sesyjna

                String value = (String)session.getAttribute(name);
                wr.append("<li>"+name+": "+value+"</li>");
            }
            wr.append("</ul>");
        }
    }
}
