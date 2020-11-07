package com.ph.model;

import javax.persistence.Id;

public class Reporte {

	private int reporteid;
	private String tipo;
	private String nombre;
	private int uma;
	
	public Reporte(int id,String tipo,String nombre,int uma){
		this.reporteid=id;
		this.tipo=tipo;
		this.nombre=nombre;
		this.uma=uma;
	}
	
	@Id
	public int getReporteid() {
		return reporteid;
	}
	public void setReporteid(int reporteid) {
		this.reporteid = reporteid;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUma() {
		return uma;
	}
	public void setUma(int uma) {
		this.uma = uma;
	}
}
