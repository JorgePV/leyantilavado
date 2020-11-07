package com.ph.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ph.config.Conexion;
import com.ph.model.Reporte;

public class ReporteDao {
	
	private Conexion con;
	private Connection connection;
	
	public List<Reporte> listarReportes() throws SQLException {
		con = new Conexion();
		List<Reporte> listarReportes = new ArrayList<Reporte>();
		String sql = "SELECT * FROM T_SREPORTES";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		Statement statement = connection.createStatement();
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
		System.out.println("desconecta y regresa lista");
		return listarReportes;
	}

}
