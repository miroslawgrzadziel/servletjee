<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  Wartość a:<c:out value="${param.a}" default="brak" /><br>
  Wartość b:<c:out value="${param.b}" default="brak" /><br>

  Cookie foo: ${cookie.foo.value}

</body>
</html>

<%--
Zadanie 3
W projekcie stwórz stronę jsp3.jsp. Następnie:
Pobierz z GET wartości a i b, następnie je wyświetl, w przypadku braku wyświetl napis brak.

Zadanie 4
W dowolnym servlecie utwórz ciasteczko o nazwie foo oraz wartości bar
W pliku jsp wyświetl wartość utworzonego ciasteczka. --%>