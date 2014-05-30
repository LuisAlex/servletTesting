<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String nombreContext =request.getSession().getServletContext().getInitParameter("HORARIO");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hola TataMundo</title>
</head>
<body>
Valor extraido desde contexto : <%=nombreContext%>
<form name="login" action="./servlet" method="post">
<label>Nombre</label>
<input type="text" name="nombre">
<label>Password</label>
<input type="text" name="login">
<input type="submit" name="loguearse" value="loguearse">
</form>

</body>
</html>