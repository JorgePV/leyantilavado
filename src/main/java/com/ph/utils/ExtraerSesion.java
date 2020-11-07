package com.ph.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExtraerSesion extends HttpServlet  {
	
	 public String nombre;
	 public void service(HttpServletRequest request, HttpServletResponse response) 
			    throws java.io.IOException, ServletException
			    {

			     // Sacar los  Datos de la Forma   
			    nombre = request.getParameter("name");
			    //String apellido = request.getParameter("apellido");

			    // Traer el Sesion del Objeto Request
			    HttpSession session = request.getSession();

			    //  Colocar los valores de la Forma en la Sesion.
			    //session.setAttribute("nombre",nombre);
			    //session.setAttribute("apellido",apellido);

			    // Indicar (Opcional) que la respuesta será tipo html
			    //response.setContentType("text/html");


			    //RequestDispatcher d = request.getRequestDispatcher("/sesiones/extraer_intermedio.jsp");
			    //d.include(request, response);
			    }
	 

}
