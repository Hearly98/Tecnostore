package com.tecnostore.controller;

import java.io.OutputStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnostore.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository repoUsu;
	
	
	
	

	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	@GetMapping("/reporteUsuarios")
	public void reporteListadoUsuarios(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reporteUsuarios.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
