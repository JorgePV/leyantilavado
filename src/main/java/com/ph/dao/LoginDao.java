package com.ph.dao;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eph.vo.EntityVO;
import com.eph.vo.commons.ResponseVO;
import com.ph.config.Conexion;
import com.ph.config.SunnelRestWSImpl;


public class LoginDao {
	private static Conexion con;
	private static Connection connection;
	

	public static boolean validate(String name, String pass) {  
		con = new Conexion();
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        SunnelRestWSImpl ws = new SunnelRestWSImpl();
        System.out.println("USER "+name);
        try {
        	ws.invokeLoginPerUser(name, pass);
        	ResponseVO<EntityVO> responseEntity = ws.getResponse();
        	
        	if (responseEntity != null)// El usuario ya se ha logueado anteriormente
            {                // en el sistema.
                //La contrasena para SUNNEL debe ser la misma que para el sistema
        		System.out.println("Entra para validar sesiones ");
                if (responseEntity.getHeader() != null && responseEntity.getHeader().getxAuthToken() != null) {
                	con.conectar();
                	String sql="select * from T_SUSUSARIO where USERNAME=?";
                	connection = con.getJdbcConnection();
                	pst = connection.prepareStatement(sql);
                	pst.setString(1, name);
                	rs = pst.executeQuery();
                    status = rs.next();
                    System.out.println("Estatus"+status);                	
                    } else {
                    	System.out.println("no es posible entrar  "+responseEntity);
                    }
            } else //Es la primera vez que se loguea este usuario. Se deben guardar sus datos en la DB del sistema
            {
            	System.out.println("no es posible entrar a la sesion   "+responseEntity);
            }
        	System.out.println("Respuesta ws desde login: "+responseEntity);
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
	
}
