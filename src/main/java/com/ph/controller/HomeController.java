package com.ph.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eph.vo.EntityVO;
import com.eph.vo.commons.ResponseVO;
import com.ph.dao.ClienteDao;
//import com.ph.dao.ClienteDao;
import com.ph.dao.LoginDao;
import com.ph.dao.ReporteDao;
import com.ph.dao.UsuarioDao;
//import com.ph.dao.UsuarioDao;
//import com.ph.model.Cliente;
import com.ph.model.Cliente;
import com.ph.model.Reporte;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/contenido")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDao clienteDao;
	ReporteDao reporteDao;

	/*public void init() {
		String jdbcURL = "Hola"; // getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = "sienko"; // getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = "anonimo"; // getServletContext().getInitParameter("jdbcPassword");
		try {

			//clienteDao = new ClienteDao(jdbcURL, jdbcUsername, jdbcPassword);
			//clienteDao = new ClienteDao();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				System.out.println("entron mostrar");
				break;
			case "home":
				home(request, response);
				System.out.println("entron home");
				break;
			case "usuario":
				usuario(request, response);
				System.out.println("valida usuariio");
				break;
			case "reporte":
				reporte(request, response);
				System.out.println("generar xmls");
				System.out.println("entro reporte");
				break;
			case "login":
				login(request, response);
				System.out.println("entron login");
				break;
			case "logout":
				login(request, response);
				System.out.println("termina sesion");
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/busqueda.jsp");
		String txtBus = request.getParameter("inputBusca");
		String txtNom = request.getParameter("inputNombre");
		String txtRfc = request.getParameter("inputRfc");
		String txtDoc = request.getParameter("inputDoc");
		String txtVul = request.getParameter("inputVul");
		String txtFec = request.getParameter("inputFecha");
		String txtTip = request.getParameter("inputTipo");
		String txtDat = request.getParameter("inputDato");
		System.out.println("Fecha: "+txtFec);		
		clienteDao = new ClienteDao();
		System.out.println("nombre: "+txtNom);
		List<Cliente> listaClientes = clienteDao.listarClientes(txtBus,txtNom,txtRfc,txtDoc,txtVul,txtFec,txtTip,txtDat);
		//List<Cliente> listaClientes = clienteDao.listarClientes();
		request.setAttribute("lista", listaClientes);
		dispatcher.forward(request, response);
	}

	private void home(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void usuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		UsuarioDao user;
		user = new UsuarioDao();
		ResponseVO<EntityVO> responseEntity = user.existeUsuario();
		System.out.println("Request"+ user);
		if (responseEntity != null)// El usuario ya se ha logueado anteriormente
        {
			System.out.println("Entro");
        }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("password");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.setMaxInactiveInterval(30);
		session.setAttribute("name", n);

		if (LoginDao.validate(n, p)) {
			//System.out.println(status);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(request, response);
		} else {
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.include(request, response);
		}

		out.close();
		// RequestDispatcher dispatcher=
		// request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		// dispatcher.forward(request, response);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);

		HttpSession session = request.getSession();
		session.invalidate();

		out.print("Sesion terminada!");

		out.close();
	}
	protected void reporte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/genXml.jsp");
		//request.getRequestDispatcher("/WEB-INF/views/genXml.jsp").include(request, response);
		
		reporteDao = new ReporteDao();
		//List<Cliente> listaClientes = clienteDao.listarClientes(txtNom,txtRfc,txtDoc,txtVul,txtFec,txtTip);
		List<Reporte> listaReportes = reporteDao.listarReportes();		
		request.setAttribute("reporte", listaReportes);
		dispatcher.forward(request, response);
		
		//HttpSession session = request.getSession();
		//session.invalidate();

		//out.print("Sesion terminada!");

		//out.close();
	}

}
