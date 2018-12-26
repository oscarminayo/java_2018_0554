package com.ipartek.formacion.listener;

import java.util.ArrayList;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojo.LoginPojo;

/**
 * Application Lifecycle Listener implementation class UsuariosListener
 *
 */
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {

	//public static HashMap<String, Usuario> usuariosLogeados = new  HashMap<String, Usuario>(); 
	public static ArrayList<LoginPojo> usuariosLogeados = new ArrayList<LoginPojo>();
	
   
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        System.out.println("attributeAdded");
        
        if ( "usuario".equals(event.getName())) {
        	
        	usuariosLogeados.add( (LoginPojo) event.getValue() );        	
        	
        	ServletContext appContext = event.getSession().getServletContext();        
            appContext.setAttribute("usuariosLogeados", usuariosLogeados);
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	 if ( "usuario".equals(event.getName())) {
          	
          	usuariosLogeados.remove((LoginPojo) event.getValue() );        	
          	
          	ServletContext appContext = event.getSession().getServletContext();        
              appContext.setAttribute("usuariosLogeados", usuariosLogeados);
          }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	
    	
    }
	
}