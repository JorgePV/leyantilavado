package com.ph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ph.config.Conexion;
import com.ph.model.BitacoraMod;
import com.ph.model.Reporte;

public class BitacoraDao {
	
	private Conexion con;
	private Connection connection;
	
	public List<BitacoraMod> listarBitacora() throws SQLException {
		con = new Conexion();
		List<BitacoraMod> listarBitacoras = new ArrayList<BitacoraMod>();
		String sql = "SELECT * FROM T_SREPORTES";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		/*Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		System.out.println("entra conexion listar reporte");
		while (resulSet.next()) {
			int id = resulSet.getInt("reporteid");
			String tipo= resulSet.getString("tipo");
			String nombre= resulSet.getString("nombre");
			int uma= resulSet.getInt("umas");
			Reporte reporte = new Reporte(id,tipo,nombre,uma);
			listarReportes.add(reporte);
			System.out.println("recorre");
		}
		con.desconectar();
		System.out.println("desconecta y regresa lista");*/
		return listarBitacoras;
	}
	
	public void GuardaBit(int cliente, String datos, String uma) throws SQLException {
		con = new Conexion();
		String sqlb = "SELECT max(envioid) + 1 maxid FROM T_SBITACORACAMBIOS";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sqlb);
		while ( rs.next() ) { 
			   // Read the next item
			//System.out.println(rs.getString("maxid"));
			String maxreeg= rs.getString("maxid");
			//System.out.println("Imprime registro");
		}
		//String s = new SimpleDateFormat("dd/MM/yyyy").format( aDate );
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hhmmss"); 
		Calendar cal = Calendar.getInstance(); 
		System.out.println(dateFormat.format(cal.getTime())); 
		LocalDateTime ldt = LocalDateTime.now();
		//Convert LocalDateTime to SQL TimeStamp
		java.sql.Timestamp dateTimeSql = java.sql.Timestamp.valueOf(ldt);
		//Set this time stamp to the query
		//preparedStatement.setDate(1, java.sql.Timestamp.valueOf(dateTimeSql));
		//try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO T_SBITACORACAMBIOS (ENVIOID, clienteid, fecha)"
                    + " VALUES (?, ?, ?)");
            prepareStatement.setInt(1, 1);
            prepareStatement.setInt(2, 1);
            //prepareStatement.setDate(3, java.sql.Timestamp.valueOf(dateTimeSql));
            prepareStatement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
            //(3, dateFormat.format(cal.getTime()));
            //prepareStatement.setString(4, dateFormat.format(cal.getTime()));
            //prepareStatement.setString(3, datos);
            //prepareStatement.setInt(6, 1);
            //prepareStatement.setNull(5, NULL);
            prepareStatement.execute();
		//} catch (SQLException e) {
            System.out.println("IT DOES NOT WORK");
        //}
		con.desconectar();	
	}

}
