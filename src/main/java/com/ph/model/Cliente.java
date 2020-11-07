package com.ph.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "T_SDETCLIENTE")
public class Cliente {

	private int reginfid;
	private int linea;
	private int clienteid;
	private String tarjeta;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private String rfc;
	private String tipocliente;
	private Date periodo;
	private int montogasto;
	private int estatusid;
	private int tipooumaid;
	private String tipoidentificacion;
	
	public Cliente(int clienteid, int linea,String tarjeta,String tipocliente,String nombre,String rfc,int monto,int status,String tipoidentificacion,Date periodo,int vulnerable) {
		this.clienteid=clienteid;
		this.linea=linea;
		this.tarjeta=tarjeta;
		this.tipocliente=tipocliente;
		this.nombre=nombre;
		this.rfc=rfc;
		this.montogasto=monto;
		this.estatusid=status;
		this.tipoidentificacion=tipoidentificacion;
		this.tipooumaid=vulnerable;
		this.periodo=periodo;
		
	} 
	
	@Id
	@GeneratedValue
	public int getReginfid() {
		return reginfid;
	}
	public void setReginfid(int reginfid) {
		this.reginfid = reginfid;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public int getClienteid() {
		return clienteid;
	}
	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTipocliente() {
		return tipocliente;
	}
	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	public int getMontogasto() {
		return montogasto;
	}
	public void setMontogasto(int montogasto) {
		this.montogasto = montogasto;
	}
	public int getEstatusid() {
		return estatusid;
	}
	public void setEstatusid(int statusid) {
		this.estatusid = estatusid;
	}
	public int getTipooumaid() {
		return tipooumaid;
	}

	public void setTipooumaid(int tipooumaid) {
		this.tipooumaid = tipooumaid;
	}
	public String getTipoidentificacion() {
		return tipoidentificacion;
	}
	public void setTipoidentificacion(String tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	public String getVulnerable() {
		return vulnerable;
	}
	public void setVulnerable(String vulnerable) {
		this.vulnerable = vulnerable;
	}
	private String vulnerable; 
	
	
	/*
	private int clienteid;
	private String nombre;
	private String rfc;
	private String tipo;
	private String documento;
	private String vulnerable;
	
	public Cliente(int clienteid,String nombre,String rfc,String tipo,String documento,String vulnerable) {
		this.clienteid=clienteid;
		this.nombre=nombre;
		this.rfc=rfc;
		this.tipo=tipo;
		this.documento=documento;
		this.vulnerable=vulnerable;
		
	} 
	
	//setters and getters
	@Id
	@GeneratedValue
	public int getClienteid() {
		return clienteid;
	}
	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getVulnerable() {
		return vulnerable;
	}
	public void setVulnerable(String vulnerable) {
		this.vulnerable = vulnerable;
	}*/
	
}
