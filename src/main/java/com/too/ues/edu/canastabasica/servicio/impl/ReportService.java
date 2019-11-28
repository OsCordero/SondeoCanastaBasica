package com.too.ues.edu.canastabasica.servicio.impl;

import java.io.FileNotFoundException;
import java.io.InputStream;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.model.ReporteSondeo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service("reporteServiceImpl")
public class ReportService {
	 @Autowired
	 @Qualifier("PeriodoSondeoRepo")
	    private PeriodoSondeoRepo repository;
	 
		
		@PersistenceContext
		private EntityManager em;


	    public String exportReport() throws FileNotFoundException, JRException {
	        /*String path = "C:\\Users\\chest\\Desktop\\Report";
	        List<PeriodoSondeo> employees = repository.findAll();
	        //load file and compile it
	        File file = ResourceUtils.getFile("classpath:reporteSondeo.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Java Techie");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	       
	       
	        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
	        

	        return "report generated in path : " + path;*/
	    	String path = "C:\\Users\\chest\\Desktop\\Report";
	    			//Long id=(long) 1;
	    	        Query nativeQuery = em.createNativeQuery("SELECT RE.PESO,\r\n" + 
	    	        		"RE.PRECIO, PR.NOMBRE_PRODUCTO, PR.ABREVIATURA, ES.NOMBRE_ESTABLECIMIENTO, M.NOMBRE_MUNICIPIO, D.NOMBRE_DEPARTAMENTO\r\n" + 
	    	        		"FROM PERIODO_SONDEO PE JOIN REGISTRO_SONDEO RE\r\n" + 
	    	        		"ON PE.ID_PERIODO = RE.ID_PERIODO\r\n" + 
	    	        		"JOIN PRODUCTO PR ON RE.ID_PRODUCTO = PR.ID_PRODUCTO\r\n" + 
	    	        		"JOIN ESTABLECIMIENTO ES ON RE.ID_ESTABLECIMIENTO = ES.ID_ESTABLECIMIENTO\r\n" + 
	    	        		"JOIN MUNICIPIO M ON ES.ID_MUNICIPIO = M.ID_MUNICIPIO \r\n" + 
	    	        		"JOIN DEPARTAMENTO D ON M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO\r\n" + 
	    	        		"ORDER BY D.ID_DEPARTAMENTO");
	    	        //((javax.persistence.Query) nativeQuery).setParameter(1, id);        
	    	        List<Object[]> records=  nativeQuery.getResultList();
	    	        List<ReporteSondeo> registros = records.stream().map(result -> new ReporteSondeo(Float.valueOf(result[0].toString()), Float.valueOf(result[1].toString()), (String) result[2], (String) result[3],(String) result[4], (String) result[5], (String) result[6])).collect(Collectors.toList());

	    	        File file = ResourceUtils.getFile("classpath:reporteSondeo.jrxml");
	    	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(registros);
	    	        Map<String, Object> parameters = new HashMap<>();
	    	        parameters.put("createdBy", "Java Techie");
	    	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	    	       
	    	       
	    	        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\sondeo.pdf");
	    	        

	    	        return "report generated in path : " + path;
	    	        
	    	        
	    	       	
	    }
}
