package com.too.ues.edu.canastabasica.model;

public class ReporteSondeo {

	private float PESO;
	private float PRECIO;
	private String NOMBRE_PRODUCTO;
	private String ABREVIATURA;
	private String NOMBRE_ESTABLECIMIENTO;
	private String NOMBRE_MUNICIPIO;
	private String NOMBRE_DEPARTAMENTO;
	
	
	
	
	public ReporteSondeo(float pESO, float pRECIO, String nOMBRE_PRODUCTO, String aBREVIATURA,
			String nOMBRE_ESTABLECIMIENTO, String nOMBRE_MUNICIPIO, String nOMBRE_DEPARTAMENTO) {
		super();
		PESO = pESO;
		PRECIO = pRECIO;
		NOMBRE_PRODUCTO = nOMBRE_PRODUCTO;
		ABREVIATURA = aBREVIATURA;
		NOMBRE_ESTABLECIMIENTO = nOMBRE_ESTABLECIMIENTO;
		NOMBRE_MUNICIPIO = nOMBRE_MUNICIPIO;
		NOMBRE_DEPARTAMENTO = nOMBRE_DEPARTAMENTO;
	}
	
	
	public ReporteSondeo() {
		super();
	}

	

	public float getPESO() {
		return PESO;
	}
	public void setPESO(float pESO) {
		PESO = pESO;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	public String getNOMBRE_PRODUCTO() {
		return NOMBRE_PRODUCTO;
	}
	public void setNOMBRE_PRODUCTO(String nOMBRE_PRODUCTO) {
		NOMBRE_PRODUCTO = nOMBRE_PRODUCTO;
	}
	public String getABREVIATURA() {
		return ABREVIATURA;
	}
	public void setABREVIATURA(String aBREVIATURA) {
		ABREVIATURA = aBREVIATURA;
	}
	public String getNOMBRE_ESTABLECIMIENTO() {
		return NOMBRE_ESTABLECIMIENTO;
	}
	public void setNOMBRE_ESTABLECIMIENTO(String nOMBRE_ESTABLECIMIENTO) {
		NOMBRE_ESTABLECIMIENTO = nOMBRE_ESTABLECIMIENTO;
	}
	public String getNOMBRE_MUNICIPIO() {
		return NOMBRE_MUNICIPIO;
	}
	public void setNOMBRE_MUNICIPIO(String nOMBRE_MUNICIPIO) {
		NOMBRE_MUNICIPIO = nOMBRE_MUNICIPIO;
	}
	public String getNOMBRE_DEPARTAMENTO() {
		return NOMBRE_DEPARTAMENTO;
	}
	public void setNOMBRE_DEPARTAMENTO(String nOMBRE_DEPARTAMENTO) {
		NOMBRE_DEPARTAMENTO = nOMBRE_DEPARTAMENTO;
	}
	
}
