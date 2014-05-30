package ServletPackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class HTMLServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public void doGet(HttpServletRequest peticion,
                    HttpServletResponse respuesta)
      throws ServletException, IOException {
    respuesta.setContentType("text/html");
    PrintWriter salida = respuesta.getWriter();
    
    
    ServletContext ctx = peticion.getServletContext();
    ctx.setAttribute("User", "Pankaj");
    String user = (String) ctx.getAttribute("User");
    HttpSession session = peticion.getSession();
    session.invalidate();
    peticion.removeAttribute(user);
    
    ServletContext permitido = peticion.getServletContext();
    String algo = permitido.getInitParameter("HORARIO");
    
    ctx.removeAttribute("User");
    salida.println("<html>\n" +
                "<head><title>Hola Mundo!</title></head>\n" +
                "<body>\n" +
                "<h1>Hola Mundo!</h1>\n" + algo +
                "</body></html>");
    }  
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String nombre= request.getParameter("nombre");
	String login= request.getParameter("login");
	
	String nombreContext =request.getSession().getServletContext().getInitParameter("USER");
	String loginContext = request.getSession().getServletContext().getInitParameter("LOGIN");
	
	response.setContentType("text/html");
    PrintWriter salida = response.getWriter();
    
    if(nombre.equals(nombreContext) && login.equals(loginContext)){
    salida.println("<html>\n" +
            "<head><title>Hola Mundo!</title></head>\n" +
            "<body>\n" +
            "<h1>Hola Mundo!</h1>\n" + 
            "<p>Bienvenido "+nombre+"</p>\n" + 
            "<p>Te logueaste morro</p>\n" + 
            "</body></html>");
    }else{
    	salida.println("<html>\n" +
                "<head><title>Usuario no autentificado</title></head>\n" +
                "<body>\n" +
                "<h1>Las credenciales no son correctas</h1>\n" + 
                "<p>intenta nuevamente chavo</p>" + 
                "</body></html>");
    	
    }
}

}