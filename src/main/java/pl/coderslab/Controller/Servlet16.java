package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalTime;

@WebServlet(name = "Servlet16", urlPatterns = {"/Servlet16"})
public class Servlet16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer wr = response.getWriter();


//        wr.append(request.getHeader("Host"));
        wr.append("IP: "+request.getLocalAddr()+"\n");
        wr.append("Przeglądarka: "+request.getHeader("User-Agent")+"\n");
        wr.append("Aktualny czas: "+LocalTime.now().toString());

//        response.getHeader(Servlet16);



    }

    private String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }
}
