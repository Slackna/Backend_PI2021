package com.cibertec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cibertec.entity.Categoria;
import com.cibertec.entity.DetalleCompras;
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

	@GetMapping(value = "/listaProductoByCat")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProductoByCat(int idCategoria) {
		List<Producto> lista = productoService.listaProductoByCat(idCategoria);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "/listaProductoByUsuario")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProductoByUsuario(int idUsuario) {
		List<Producto> lista = productoService.listaProductoporUsuario(idUsuario);
		return ResponseEntity.ok(lista);
	}
	@ResponseBody
	@PostMapping(value = "/registraProducto"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public Map<String, Object> registra(@RequestPart(name = "files")  MultipartFile files)  {
		
		Map<String, Object> salida = new HashMap<>();
		List<String> filenames=new ArrayList<>();
		
		Arrays.asList(files).stream().forEach(file->{
			filenames.add(file.getOriginalFilename());
		});
		
		/*try {
			Producto objSalida = productoService.insertaActualizaProducto(nuevoProducto);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}*/
		salida.put("mensaje", filenames.toString());
		return salida;

}
	
	 @GetMapping("/detail/{id}")
	    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
	        Producto producto = productoService.obtienePorId(id).get();
	        return new ResponseEntity(producto, HttpStatus.OK);
	    }
}
