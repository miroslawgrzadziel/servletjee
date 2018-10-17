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

@WebServlet(name = "Get5", urlPatterns = {"/Get5"})
public class Get5 extends HttpServlet {
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
//Zadanie 5
//W projekcie stwórz servlet Get5, dostępny pod adresem /Get5, oraz stronę HTML index.html, w której umieścisz link do servletu z dodatkowymi parametrami
//?company=coderslab&learn=php&learn=java&learn=ruby&learn=python
//po przejściu do servletu wyświetl informacje w następujący sposób:
//
//company:
//  - coderslab
//learn:
//  - php
//  - java
//  - ruby
//  - python