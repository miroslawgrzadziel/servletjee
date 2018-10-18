package pl.coderslab.Controller;

import pl.coderslab.Model.CartItem;

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

@WebServlet(name = "Sess04", urlPatterns = {"/Sess04"})
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            String name = request.getParameter("name");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));

            //create element which we save to session
            CartItem cartItem = new CartItem(name, quantity, price);

            HttpSession session = request.getSession();
            List<CartItem> cartItemList = (List<CartItem>)  session.getAttribute("cart");

            if(cartItemList == null)
                cartItemList = new ArrayList<>();

            cartItemList.add(cartItem);

            session.setAttribute("cart", cartItemList);


        }catch (Exception e){
            response.getWriter().append("Wrong data");
        }

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        HttpSession session = request.getSession();

        List<CartItem> itemList = (List<CartItem>) session.getAttribute("cart");

        wr.append("<a href='/index_04.html'>Dodaj</a>");

        if(itemList != null){

            double sum = 0;
            for(CartItem cartItem : itemList){

                double itemValue = cartItem.getPrice() * cartItem.getQuantity();
                sum += itemValue;

                wr.append("<p>"+cartItem.getName()+" - "+cartItem.getQuantity()+" x "+cartItem.getPrice()+"zł = "+itemValue+"zł</p>");

            }

            wr.append("<p>SUMA: "+sum+"</p>");



        }

    }
}
//Zadanie 4
//W projekcie stwórz servlet Sess04 oraz stronę HTML index_04.html. Następnie:
//
//Dodaj do strony formularz, zawierający jedno pole tekstowe (nazwa) oraz dwa pola liczbowe (ilość i cena) służące do dodawania produktu do koszyka. Formularz powinien przekierować do servletu metodą POST.
//Po odebraniu danych POST w servelecie, dodaj do sesji przedmiot. Pamiętaj, że przedmiotów będzie więcej, więc użyj do tego tablicy lub kolekcji.
//Dodaj do servletu funkcjonalność, która wyświetli zawartość naszego koszyka. Zawartość ma być wyświetlana zarówno w przypadku wejścia metodą GET, jak i metodą POST.
//Przykładowy koszyk:
//
//Produkt 1 - 4 x 5.20zł = 20.80zł
//Produkt 2 - 1 x 9.99zł =  9.99zł
//Produkt 3 - 1 x 2.20zł =  2.20zł
//                   SUMA: 32.99zł
//Informacje o produkcie możesz przechowuj w dodatkowej klasie: CartItem zawierającej pola name, quantity, price.
















//todo to będzie na egzaminie