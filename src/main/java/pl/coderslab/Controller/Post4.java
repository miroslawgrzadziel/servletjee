package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@WebServlet(name = "Post4", urlPatterns = {"/Post4"})
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        String[] valArr = request.getParameterValues("numbers");
        List<Integer> numbersList = new ArrayList<>();

        for(String number : valArr)
        {
            try
            {
                numbersList.add(Integer.parseInt(number));
            }
            catch(NumberFormatException e)
            {
                continue;
            }
        }

        numbersList.sort((a, b) -> a - b);

        for(Integer number : numbersList)
        {
            wr.append(number + " ");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        Random r = new Random();
        int a = r.nextInt(6)+5;

        wr.append("<form action='' method='post'>");
        for (int i = 1; i <= a; i++) {
            wr.append("<input name='numbers' placeholder='wpisz wartość liczbową'/><br/>");
        }
        wr.append("<input type='submit'/></form>");

    }
}
//Zadanie 4
//W projekcie stwórz servlet Post4. Następnie:
//
//w metodzie doGet, będzie wyświetlał formularz z losową ilością parametrów (w zakresie od 5 do 10) o takiej samej nazwie numbers.
//W metodzie doPost pobierz wszystkie parametry - te z nich, które reprezentują wartość liczbową, wyświetl posortowane od najmniejszego do największego.
//Skorzystaj z poniższego formularza:
//
//<form action='' method='post'>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//
//<!-- parametrów może być więcej  -->
//
//<input type='submit'/>
//</form>