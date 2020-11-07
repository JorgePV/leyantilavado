package com.ph.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.ph.dao.BitacoraDao;
import com.ph.utils.ExtraerSesion;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Valida {

	private Conexion con;
	private Connection connection;
	
	public boolean validaInfo(String usuario) throws SQLException {
		con = new Conexion();
		con.conectar();
		connection = con.getJdbcConnection();
		
		String sql = "SELECT inf.mesreportado,inf.clavesujetoobligado,inf.claveactividad,inf.referenciaaviso,inf.prioridad,alr.tipoalerta,alr.descripcion,CLIENTEID,NOMBRE,APELLIDOPATERNO,APELLIDOMATERNO,RFC, FECHANACIMIENTO,nacionalidad,'clave exom' CLAVEECONOMICA\r\n" + 
				",COLONIA,CALLE,NUMEROEXTERIOR, CODIGOPOSTAL,CLAVEPAIS, TELEFONO, TELEFONO, FECHAPERIODO, FECHAPERIODO, TIPOOPERACION,TIPOTARJETA, NUMIDENTIFICADOR,MONTOGASTO\r\n" + 
				"FROM T_SDETCLIENTE DTC, T_SINFORME INF,t_salerta ALR\r\n" + 
				"where inf.informeid=dtc.informeid\r\n" + 
				"and alr.alertaid=alr.alertaid and REGINFID < 20 order by dtc.reginfid";
		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);	
		//String [] regNull;
		ArrayList<String> regNull = new ArrayList<String>();
		ArrayList<String> countReg = new ArrayList<String>();
		String concatena ="";
		String concatenaFin ="";
		String id = "";
		String rfc = "";
		while (rs.next()) {
			concatena ="";
			concatenaFin ="";
			for (int x=1;x<=rs.getMetaData().getColumnCount();x++) {
				if (rs.getString(x) == null) {
			    String Valor=rs.getMetaData().getColumnName(x);; 
				//System.out.println("");			    
				concatena += Valor;
				concatena +=" |* ";
				}else {
				}			    
			}
			id ="ID Cliente - "+rs.getInt("clienteid")+"  ";
			if(concatena != "") {
				concatenaFin +=id;
				concatenaFin +=concatena;
				countReg.add(concatenaFin);
			}
			else {
				rfc =rs.getString("rfc");
				rfc.length();
				if(rfc.length() < 10) {
					concatena="  Revisar RFC";
					concatenaFin +=id;
					concatenaFin +=concatena;
					countReg.add(concatenaFin);
					
				}else if (rfc.length() > 13) {
					concatena="  Revisar RFC";
					concatenaFin +=id;
					concatenaFin +=concatena;
					countReg.add(concatenaFin);					
				}else {
					//No se agrega nada en arreglo
				}
			}
		}
		
		int size=countReg.size();
		System.out.println("Lista de reegistro con problemas : "+ size);
		
		 for (int i=0;i<countReg.size();i++) {		      
		      //System.out.println(countReg.get(i));
		 }		
		con.desconectar();		
		System.out.println("desconecta Validacion Regisrtros");
		return true;
	}
	
	public void actualizaInfo(int reporte) throws SQLException {
		
	}
	
	public void notifica(int reporte) throws SQLException {
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SQLException {		
		//if(sesion.getAttribute("usuario") == null){
			   //redirijo al login
		//}
		//String nom="";
		//ExtraerSesion sesion=new ExtraerSesion();
		//nom=sesion.nombre;
		//System.out.println("Sesion-- " +nom);
		BitacoraDao bitEnv= new BitacoraDao();
		int cliente=1;
		String datos="comexion";
		String uma="1";
		bitEnv.GuardaBit(cliente, datos, uma);
		Valida val = new Valida();
		String reporte="1";
		val.validaInfo(reporte);
	}
	
}
