package ServletPackage;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
 
public class LogFilter implements Filter {
 
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
         
        //Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();
        

        
        String etiqueta;
    	int time = new Date( ).getSeconds();
    	if (time > 30){
         request.getSession().getServletContext().setAttribute("HORARIO", "Esta fuera de horario permitido");
       
    	}else{
    		request.getSession().getServletContext().setAttribute("HORARIO", "Dentro del horario permitido");
    	}

    	//System.out.println(req.getAttribute("HORARIO"));
        
        
        
        
        
        
         
        chain.doFilter(req, res);
    }
    public void init(FilterConfig config) throws ServletException {
         
    	String etiqueta;
    	int time = new Date( ).getSeconds();
    	
    	
    	
    	 	//Get init parameter
    	if (time > 30){
        etiqueta = config.getInitParameter("FiltroTrue");
       
    	}else{
    		 etiqueta = config.getInitParameter("FiltroFalse");
    	}
        //Print the init parameter
        System.out.println(etiqueta);
        System.out.println("Tiempo: " + new Date().toString());
      
    }
    public void destroy() {
        //add code to release any resource
    }
}
