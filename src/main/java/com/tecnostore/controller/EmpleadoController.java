package com.tecnostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnostore.model.Empleado;
import com.tecnostore.repository.CargoRepository;
import com.tecnostore.repository.EmpleadoRepository;
import com.tecnostore.repository.GeneroRepository;

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
}
