package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess02", urlPatterns = {"/Sess02"})
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Double> grades = (List<Double>) session.getAttribute("grades");

        if(grades == null){
            grades = new ArrayList<>();
        }

        try{

            double grade = Double.parseDouble( request.getParameter("grade") ) ;
            if(grade < 1 || grade > 6){
                throw new Exception("Value must be between 1 and 6");
            }

            grades.add(grade);
            session.setAttribute("grades", grades);

        }catch (Exception e){
            response.getWriter().append( "Wrong data: "+e.getMessage() );
        }

        doGet(request, response); //wywołuje metodę doGet żeby obsłużyć wyświetlanie komunikatów o błędzie

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        Writer wr = response.getWriter();

        wr.append("<form method='post'>" +
                "<input type='text' name='grade' placeholder='grade' />" +
                "<input type='submit' />" +
                "</form>");


        List<Double> grades = (List<Double>) session.getAttribute("grades");

        if(grades != null){

            double sum = 0;
            wr.append("<ul>");
            for(Double grade : grades){
                sum += grade;
                wr.append("<li>"+grade+"</li>");
            }
            wr.append("</ul>");

            double avg = sum / grades.size();
            wr.append("<p>Avg: "+avg+"</p>");

        }


    }
}
//Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Sess02. Następnie:
//
//Dodaj do niego formularz z możliwością wpisania oceny.
//Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w tablicy, którą będziesz wkładać do sesji. Zadbaj o walidację wprowadzanych ocen (nie mniej niż 1 i nie więcej niż 6).
//Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
//Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane pod formularzem.