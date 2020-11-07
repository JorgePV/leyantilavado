package com.ph.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {
	
	/*static final public void main(String[] args) {
		ConfigurationLoader prt = new ConfigurationLoader();
		prt.getUsuario();
        System.out.println("USR:  "+prt.getUrl());
        System.out.println("static, final y public");
    }*/
	
	private String usuario;
	private String password;
	private String className;
	private String host;
	private String port;
	private String bd;
	private String url;
	private String userws;
	private String passws;
	private String uriSearchAccountWs;
	private String urlws;
	
	public ConfigurationLoader() {
		
		try {
			  
			/**Creamos un Objeto de tipo Properties*/
			   Properties propiedades = new Properties();
			   
			   /**Cargamos el archivo desde la ruta especificada*/
			   propiedades.load(new FileInputStream("D:\\Proyectos\\spring_maven\\propiedades_antilavado\\resursos.properties"));
			   //propiedades.load(new FileInputStream("resursos.properties"));
			   
			   /**Obtenemos los parametros definidos en el archivo*/
			   usuario = propiedades.getProperty("usuario");
			   password = propiedades.getProperty("password");
			   className = propiedades.getProperty("jdbc.driverClassName");
			   host = propiedades.getProperty("servidor");
			   port = propiedades.getProperty("puerto");
			   bd = propiedades.getProperty("base"); 
			   url = "jdbc:oracle:thin:@"+host+":"+port+":"+bd;
			   userws=propiedades.getProperty("userWs");
			   passws=propiedades.getProperty("passwordWs");
			   uriSearchAccountWs=propiedades.getProperty("uriSearchAccountWS");
			   urlws=propiedades.getProperty("uriLoginWS");
			   //usuario="SDF";
			   this.usuario=usuario;
			   this.password=password;
			   this.className=className;
			   this.host=host;
			   this.port=port;
			   this.bd=bd;
			   this.url=url;
			   this.userws=userws;
			   this.passws=passws;
			   this.uriSearchAccountWs=uriSearchAccountWs;
			   this.urlws=urlws;
			   
			  } catch (FileNotFoundException e) {
			   System.out.println("Error, El archivo no exite");
			  } catch (IOException e) {
			   System.out.println("Error, No se puede leer el archivo");
			  }	

	}
	
	public String getUserws() {
		return userws;
	}

	public void setUserws(String userws) {
		this.userws = userws;
	}

	public String getPassws() {
		return passws;
	}

	public void setPassws(String passws) {
		this.passws = passws;
	}

	public String getUriSearchAccountWs() {
		return uriSearchAccountWs;
	}

	public void setUriSearchAccountWs(String uriSearchAccountWs) {
		this.uriSearchAccountWs = uriSearchAccountWs;
	}

	public String getUrlws() {
		return urlws;
	}

	public void setUrlws(String urlws) {
		this.urlws = urlws;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getClassName() {
		return className;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getBd() {
		return bd;
	}

	public String getUrl() {
		return url;
	}
}