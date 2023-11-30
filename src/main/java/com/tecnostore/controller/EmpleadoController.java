package com.tecnostore.controller;

import java.io.OutputStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tecnostore.model.Empleado;
import com.tecnostore.model.Producto;
import com.tecnostore.repository.CargoRepository;
import com.tecnostore.repository.EmpleadoRepository;
import com.tecnostore.repository.GeneroRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class EmpleadoController {
	@Autowired
	private CargoRepository repoCargo;
	@Autowired
	private EmpleadoRepository repoEmpleado;
	@Autowired
	private GeneroRepository repoGenero;

	@GetMapping("/manteEmpleados")
	public String mostrarEmpleados(Model model) {

		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lstCargo", repoCargo.findAll());
		model.addAttribute("lstEmpleado", repoEmpleado.findAll());
		model.addAttribute("lstGenero", repoGenero.findAll());

		return "mantenimientoEmpleado";

	}
	
	
	@PostMapping("/registrarEmpleado")
    public String grabar(@ModelAttribute Empleado empleado,Model model) {
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lstCargo", repoCargo.findAll());
		model.addAttribute("lstEmpleado", repoEmpleado.findAll());
		model.addAttribute("lstGenero", repoGenero.findAll());
          
        try {
            repoEmpleado.save(empleado);
            model.addAttribute("mensaje", "Registro OK ");
            model.addAttribute("tipoMensaje", "success");
        } catch (Exception e){
            model.addAttribute("mensaje", "Error al registrar ");
	        model.addAttribute("tipoMensaje", "error");
        }
        System.out.println(empleado);

        //retorno
        return "mantenimientoEmpleado";

    }
	
	
	
	
	
	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	@GetMapping("/reporteEmpleados")
	public void reporteListadoEmpleados(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reporteEmpleados.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
}
