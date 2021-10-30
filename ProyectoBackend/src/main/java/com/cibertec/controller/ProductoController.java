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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<Producto>> listaProducto(){
		List<Producto> lista = productoService.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value = "/registraProducto")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida = productoService.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	@RequestMapping(value = "/verImagen/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") int imageId) throws IOException {

		Optional<Producto> optProducto= productoService.obtienePorId(imageId);

		byte[] imageContent = optProducto.get().getImg();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	

}
