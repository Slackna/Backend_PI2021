package com.cibertec.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Compras;
import com.cibertec.entity.Producto;
import com.cibertec.entity.Usuario;
import com.cibertec.security.dto.NuevoUsuario;
import com.cibertec.security.entity.Rol;
import com.cibertec.security.service.RolService;
import com.cibertec.service.UsuarioService;
import com.cibertec.util.Constantes;
import com.cibertec.util.Mensaje;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RolService rolService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping(value = "/listaUsuario")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> lista = usuarioService.listaUsuario();
		return ResponseEntity.ok(lista);
	}
	
	 @PutMapping("/actualiza")
		@ResponseBody
		public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Usuario obj) {
			Map<String, Object> salida = new HashMap<>();
			try {
				if (obj.getIdUsuario() == 0) {
					salida.put("mensaje", "El ID del Docente debe ser diferente cero");
					return ResponseEntity.ok(salida);
				}
				Usuario objSalida = usuarioService.insertaActualizaUsuario(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
				}
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			}
			return ResponseEntity.ok(salida);
		}
	
	

	@PostMapping("/registraUsuario")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido"), HttpStatus.OK);
		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.OK);
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.OK);
		Usuario usuario = new Usuario(nuevoUsuario.getNombreUsuario(),
				passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getNombre(),
				nuevoUsuario.getPaterno(), nuevoUsuario.getMaterno(), nuevoUsuario.getDni(), nuevoUsuario.getDireccion(),
				nuevoUsuario.getCelular(), nuevoUsuario.getEmail(), nuevoUsuario.getRuc(),
				nuevoUsuario.getRazonSocial());
		Set<Rol> roles = new HashSet<>();

		Rol rol = new Rol();
		rol.setId(2);
		rol.setRolNombre("ROLE_USER");
		roles.add(rol);
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre("ROLE_ADMIN").get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaVendedor() {
		List<Usuario> lista = usuarioService.listaVendedor();
		return ResponseEntity.ok(lista);
	}

}
