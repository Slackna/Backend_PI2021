package com.cibertec.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.entity.Categoria;
import com.cibertec.entity.Producto;
import com.cibertec.service.ProductoService;
import com.cibertec.util.Constantes;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	@Autowired
	private ProductoService productoService;

	@GetMapping(value = "/listaProducto")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = productoService.listaProducto();
		return ResponseEntity.ok(lista);
	}

	@ResponseBody
	@PostMapping(value = "/registraProducto", consumes = "multipart/form-data")
	public Map<String, Object> registra(@RequestParam("nombre") String nombre, @RequestParam("marca") String marca,
			@RequestParam("precio") double precio, @RequestParam("direccion") String direccion,
			@RequestParam("descripcion") String descripcion, @RequestParam("condicion") String condicion,
			@RequestParam("id_categoria") Categoria categoria, @RequestParam("img1") List<MultipartFile> img1) {
		Map<String, Object> salida = new HashMap<>();
		try {

			// Registra en la base de datos
			Producto obj = new Producto();
			obj.setNombre(nombre);
			obj.setMarca(marca);
			obj.setPrecio(precio);
			obj.setDireccion(direccion);
			obj.setCondicion(condicion);
			obj.setDescripcion(descripcion);
			obj.setCategoria(categoria);

			Producto objSalida = productoService.insertaActualizaProducto(obj, img1);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return salida;
	}

}
