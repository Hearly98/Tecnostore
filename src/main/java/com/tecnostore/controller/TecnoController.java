package com.tecnostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecnostore.model.Producto;
import com.tecnostore.model.Usuario;
import com.tecnostore.repository.CategoriaRepository;
import com.tecnostore.repository.EstadoRepository;
import com.tecnostore.repository.MarcaRepository;
import com.tecnostore.repository.ProductoRepository;
import com.tecnostore.service.UsuarioService;

@Controller
public class TecnoController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CategoriaRepository repoCategoria;
	@Autowired
	private EstadoRepository repoEstado;
	@Autowired
	private MarcaRepository repoMarca;
	@Autowired
	private ProductoRepository repoProducto;

	// ------------------------------------ LOGIN
	// CONTROLLER------------------------------------------------

	@GetMapping("/iniciarLogin")
	public String abrirPaginaLogin() {
		return "login.html";
	}

	@PostMapping("/iniciarLogin")
	public String iniciarSesion(Model model, @RequestParam(name = "email") String email,
			@RequestParam(name = "clave") String clave) {

		Usuario usuario = usuarioService.buscarPorEmail(email);

		if ("admin@mail.com".equals(email) && "123456".equals(clave)) {
			// Inicio de sesión admin
			model.addAttribute("tituloMensaje", "Bienvenido Administrador");
			model.addAttribute("mensaje", "¡Es hora de chambear!");
			model.addAttribute("tipoMensaje", "success");
			model.addAttribute("p", new Producto());
			return "menu";
		} else {

			if (usuario != null) {
				if (usuario.getClave().equals(clave)) {
					// Inicio de sesión exitoso
					model.addAttribute("tituloMensaje", "Inicio de sesión exitoso");
					model.addAttribute("mensaje", "¡Bienvenido " + usuario.getNombre() + "!");
					model.addAttribute("tipoMensaje", "success");
					model.addAttribute("index.html", usuario);
				} else {
					// Contraseña incorrecta
					model.addAttribute("tituloMensaje", "Error de inicio de sesión");
					model.addAttribute("mensaje", "Contraseña Incorrecta");
					model.addAttribute("tipoMensaje", "error");
				}
			} else {
				// Usuario no encontrado en la base de datos
				model.addAttribute("tituloMensaje", "Error de inicio de sesión");
				model.addAttribute("mensaje", "El correo no existe");
				model.addAttribute("tipoMensaje", "error");
			}
			return "login.html";
		}
	}

	// ------------------------------------ REGISTRO
	// CONTROLLER-----------------------------------------------

	@GetMapping("/abrirPaginaRegistro")
	public String abrirPaginaRegistro() {
		return "register";
	}

	@PostMapping("/registrarUsuario")
	public String registrarUsuario(Model model, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "apellido") String apellido, @RequestParam(name = "email") String email,
			@RequestParam(name = "clave") String clave, @RequestParam(name = "telefono") String telefono) {

		if (!nombre.matches("^[a-zA-Z ]+$")) {
			model.addAttribute("tituloMensaje", "Error en el registro");
			model.addAttribute("mensaje", "El nombre contiene caracteres inválidos.");
			model.addAttribute("tipoMensaje", "error");
			return "register";
		}
		if (!apellido.matches("^[a-zA-Z ]+$")) {
			model.addAttribute("tituloMensaje", "Error en el registro");
			model.addAttribute("mensaje", "El apellido contiene caracteres inválidos.");
			model.addAttribute("tipoMensaje", "error");
			return "register";
		}
		if (!telefono.matches("^9\\d{8}$")) {
			model.addAttribute("tituloMensaje", "Error en el registro");
			model.addAttribute("mensaje", "El teléfono es inválido. Debe tener 9 dígitos y comenzar con 9.");
			model.addAttribute("tipoMensaje", "error");
			return "register";
		}

		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setApellido(apellido);
		nuevoUsuario.setEmail(email);
		nuevoUsuario.setClave(clave);
		nuevoUsuario.setTelefono(telefono);

		try {
			usuarioService.guardarUsuario(nuevoUsuario);

			model.addAttribute("tituloMensaje", "Registro exitoso");
			model.addAttribute("mensaje", "Te registraste de manera exitosa");
			model.addAttribute("tipoMensaje", "success");

		} catch (Exception e) {

			model.addAttribute("mensaje", "Error al registrar el usuario");
		}

		return "login";
	}

	// ------------------------------ Listado de productos-------------------------

	@GetMapping("/listadoprods")
	public String mostrarPaginaConsulta(Model model) {

		model.addAttribute("lstProductos", repoProducto.findAll());
		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());

		return "listadoProductos";

	}

	// ----------------------------- Editar producto-----

	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable int id, Model model) {
		Producto producto = repoProducto.findById(id).get();

		model.addAttribute("p", producto);

		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());

		return "mantenimiento";
	}

	// -------------------------------- Solo
	// Mantenimiento-----------------------------
	@GetMapping("/mantenimiento")
	public String abrirPaginaMantenimiento(Model model) {
		Producto producto = new Producto();

		model.addAttribute("p", producto);
		model.addAttribute("lstProductos", repoProducto.findAll());
		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());

		return "mantenimiento";
	}

	// -----------------------------------Eliminar-----------------------------------------

	@PostMapping("/eliminar")
	public String eliminar(Producto producto, Model model) {

		model.addAttribute("lstProductos", repoProducto.findAll());
		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());

		try {

			repoProducto.delete(producto);
			model.addAttribute("tituloMensaje", "Eliminación exitosa");
			model.addAttribute("mensaje", "El producto se logró eliminar correctamente");
			model.addAttribute("tipoMensaje", "success");

		} catch (Exception e) {

			model.addAttribute("mensaje", "Ocurrio un problema al eliminar el producto");
			model.addAttribute("tipoMensaje", "error");
		}

		Producto p = new Producto();
		model.addAttribute("p", p);

		return "mantenimiento";
	}


	// --------- REGISTRAR PRODUCTO-----
	@GetMapping("/registroProductos")
	public String abrirRegistroProductos(Model model) {
		Producto producto = new Producto();

		model.addAttribute("p", producto);

		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());
		return "registroProductos";
	}
	
	// ------------------------ Actualizar producto----------------------------

	@PostMapping("/actualizar")
	public String actualizarProducto(@Validated @ModelAttribute("productos") Producto producto, BindingResult result, Model model) {
		
		model.addAttribute("lstProductos", repoProducto.findAll());
		model.addAttribute("lstCategoria", repoCategoria.findAll());
		model.addAttribute("lstEstado", repoEstado.findAll());
		model.addAttribute("lstMarca", repoMarca.findAll());
		model.addAttribute("p", producto);

		
		try {
	        if (result.hasErrors()) {
	            model.addAttribute("mensaje", "Por favor, complete todos los campos obligatorios");
	            model.addAttribute("tipoMensaje", "error");
	            return "mantenimiento";
	        }
	        
	        Producto productoExistente = repoProducto.findById(producto.getId()).orElse(null);

	        if (productoExistente != null) {
	            repoProducto.save(producto);
	            
	            model.addAttribute("tituloMensaje", "Actualización exitosa");
	            model.addAttribute("mensaje", "El producto se actualizó correctamente");
	            model.addAttribute("tipoMensaje", "success");
	            return "mantenimiento";

	        } else {
	            model.addAttribute("mensaje", "No se encontró el producto para actualizar");
	            model.addAttribute("tipoMensaje", "error");
	            return "mantenimiento";
	        }

	    } catch (Exception e) {
	        model.addAttribute("mensaje", "Ocurrió un error al actualizar el producto");
	        model.addAttribute("tipoMensaje", "error");
	        return "mantenimiento";
	    }
	}
	
	//------------------ Menu
	
	@GetMapping("/menu")
	public String abrirMenu() {
		return "Menu";
	}
}
