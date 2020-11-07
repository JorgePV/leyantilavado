package com.ph.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ph.config.Conexion;
import com.ph.model.Cliente;


public class ClienteDao {
	private Conexion con;
	private Connection connection;
	
	
	
	/*static final public void main(String[] args) throws Exception{
		//ClienteDao();
		ClienteDao l = new ClienteDao("ult", "sienko", "anonimo");
		l.listarClientes();
		System.out.println("Hello World");
		
	}*/
	public List<Cliente> listarClientes(String txtBus,String txtNom,String txtRfc,String txtDoc,String txtVul,String txtFec,String txtTip, String txtDat) throws SQLException {	
		con = new Conexion();
		System.out.println(" Dentro Listar");
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String sql="";
		if(txtBus !=null && txtNom !=null && txtRfc !=null && txtDoc !=null && txtVul !=null && txtFec !=null && txtTip !=null && txtDat !=null){
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'\r\n" + 
					"AND tipoidentificacion='"+txtDoc+"'\r\n" + 
					"AND TIPOUMAID='"+txtVul+"'\r\n" + 
					"AND fechaperiodo=TO_DATE('"+txtFec+"','yyyy-mm-dd')\r\n" + 
					"AND tipopersonaid='"+txtTip+"'\r\n" + 
					"AND estatusid='"+txtDat+"'";
		}else if(txtBus !=null && txtNom !=null && txtRfc !=null && txtDoc !=null && txtVul !=null && txtFec !=null && txtTip !=null){
			System.out.println(" Encontrar por 7 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'\r\n" + 
					"AND tipoidentificacion='"+txtDoc+"'\r\n" + 
					"AND TIPOUMAID='"+txtVul+"'\r\n" + 
					"AND fechaperiodo=TO_DATE('"+txtFec+"','yyyy-mm-dd')\r\n" + 
					"AND tipopersonaid='"+txtTip+"'";
		}else if(txtBus !=null && txtNom !=null && txtRfc !=null && txtDoc !=null && txtVul !=null && txtFec !=null){
			System.out.println(" Encontrar por 6 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'\r\n" + 
					"AND tipoidentificacion='"+txtDoc+"'\r\n" + 
					"AND TIPOUMAID='"+txtVul+"'\r\n" + 
					"AND fechaperiodo=TO_DATE('"+txtFec+"','yyyy-mm-dd')";
		}else if(txtBus !=null && txtNom !=null && txtRfc !=null && txtDoc !=null && txtVul !=null){
			System.out.println(" Encontrar por 5 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'\r\n" + 
					"AND tipoidentificacion='"+txtDoc+"'\r\n" + 
					"AND TIPOUMAID='"+txtVul+"'";
		}else if(txtBus !=null && txtNom !=null && txtRfc !=null && txtDoc !=null){
			System.out.println(" Encontrar por 4 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'\r\n" + 
					"AND tipoidentificacion='"+txtDoc+"'";
		}else if(txtBus !=null && txtNom !=null && txtRfc !=null){
			System.out.println(" Encontrar por 3 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'\r\n" +
					"AND RFC='"+txtRfc+"'"; 
		}else if(txtBus !=null && txtNom !=null){
			System.out.println(" Encontrar por 2 ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"' \r\n" + 
					"AND nombre='"+txtNom+"'";
		}else if(txtBus !=null && !txtBus.isEmpty()){
			System.out.println(" Encontrar por txtBus ");
			sql = "SELECT * FROM T_SDETCLIENTE where clienteid='"+txtBus+"'";
		}else if(txtNom != null && !txtNom.isEmpty()){
			System.out.println(" Encontrar por txtNom ");
			sql = "SELECT * FROM T_SDETCLIENTE where nombre='"+txtNom+"'";
		}else if(txtRfc !=null && !txtRfc.isEmpty()){
			System.out.println(" Encontrar por txtRfc ");
			sql = "SELECT * FROM T_SDETCLIENTE where RFC='"+txtRfc+"'";
		}else if(txtDoc !=null && !txtDoc.isEmpty()){
			System.out.println(" Encontrar por txtDoc -- " + txtDoc);
			sql = "SELECT * FROM T_SDETCLIENTE where tipoidentificacion='"+txtDoc+"'";
		}else if(txtVul !=null && !txtVul.isEmpty()){
			System.out.println(" Encontrar por txtVul ");
			sql = "SELECT * FROM T_SDETCLIENTE where TIPOUMAID='"+txtVul+"'";
		}else if(txtFec !=null && !txtFec.isEmpty()){
			sql = "SELECT * FROM T_SDETCLIENTE where fechaperiodo=TO_DATE('"+txtFec+"','yyyy-mm-dd')";
		}else if(txtTip !=null && !txtTip.isEmpty()){
			sql = "SELECT * FROM T_SDETCLIENTE where tipopersonaid='"+txtTip+"'";
		}else if(txtDat !=null && !txtDat.isEmpty()){
			sql = "SELECT * FROM T_SDETCLIENTE where estatusid='"+txtDat+"'";
		}
		//sql = "";
		if (sql != "") {
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);		
		while (resulSet.next()) {
			int id = resulSet.getInt("clienteid");
			int linea = resulSet.getInt("linea");
			String tarjeta = resulSet.getString("tarjeta");
			String tipocliente=resulSet.getString("tipocliente");
			String nombre = resulSet.getString("nombre");
			String appaterno = resulSet.getString("apellidopaterno");
			String apmaterno = resulSet.getString("apellidomaterno");
			String rfc = resulSet.getString("rfc");
			int monto = resulSet.getInt("montogasto");
			int estatus = resulSet.getInt("estatusid");
			String tipo = resulSet.getString("tipocliente");
			String documento = resulSet.getString("tipoidentificacion");
			int vulnerable = resulSet.getInt("tipoumaid");
			Date periodo= resulSet.getDate("fechaperiodo");
			nombre= nombre +" "+ appaterno +" "+apmaterno;
			System.out.println("nombre:  "+nombre);
			System.out.println("documento:  "+rfc);
			Cliente cliente = new Cliente(id,linea,tarjeta,tipocliente, nombre, rfc,monto, estatus,documento,periodo, vulnerable);
			listaClientes.add(cliente);
			System.out.println("recorre");
		}
		con.desconectar();
		System.out.println("desconecta y regresa lista");
		}
		
		return listaClientes;
	}

}
