<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/ControladorLoginVedel" method="post">
        <center>
            <div class="login">
                <input class="input_text" type="text" name="usuario" placeholder="Usuario"><br>
                <input class="input_text" type="password" name="password" placeholder="Contraseña"><br>
                <input class="input_butt" type="submit" value="ACEPTAR" name="botonEnviar">	
            </div>
        </center>
        </form>
    </body>
</html>