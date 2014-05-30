package ServletPackage;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
 
@WebListener
public class MyServletRequestListener implements ServletRequestListener,ServletContextAttributeListener,HttpSessionListener {
 
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("ServletRequest destroyed. Remote IP="+servletRequest.getRemoteAddr());
    }
 
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("arrancamos");
        System.out.println("ServletRequest initialized. Remote IP="+servletRequest.getRemoteAddr());
    }
    
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("Session Created:: ID="+sessionEvent.getSession().getId());
        
    }
 
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
    }
    
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute added::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
 
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute replaced::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
 
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute removed::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
     
}
