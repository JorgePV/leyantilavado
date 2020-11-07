package com.ph.config;

import java.sql.*;

public class Conexion {
	private Conexion con;
	private Connection connection;

	private Connection jdbcConnection;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private String jdbcClasname;

	public Conexion() {
		ConfigurationLoader prt = new ConfigurationLoader();
		this.jdbcURL = prt.getUrl();
		this.jdbcUsername = prt.getUsuario();
		this.jdbcPassword = prt.getPassword();
		this.jdbcPassword = prt.getPassword();
		this.jdbcClasname = prt.getClassName();
	}

	public void conectar() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(jdbcClasname);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("url con   ---");
		}
		System.out.println("conecta .: --: " + jdbcConnection);
		System.out.println("Connected to database");
	}

	public void desconectar() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}

}
