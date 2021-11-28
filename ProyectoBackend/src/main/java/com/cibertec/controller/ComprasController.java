package com.cibertec.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cibertec.entity.DetalleCompras;
import com.cibertec.entity.Pedido;
import com.cibertec.entity.Producto;
import com.cibertec.entity.Usuario;
import com.cibertec.service.ComprasService;
import com.cibertec.service.DetalleComprasService;
import com.cibertec.service.UsuarioService;
import com.cibertec.util.Constantes;
import com.cibertec.service.PedidoService;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class ComprasController {
 
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private ComprasService compraService;
	
	@Autowired
	private DetalleComprasService detalleService;
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@ResponseBody
	@PostMapping(value = "/guardarCompra/{id}")
	public Map<String, Object> registra(@RequestBody Compras nuevaCompra,@PathVariable Producto id) {
		DetalleCompras detalle = new DetalleCompras();
		Pedido pedido = new Pedido();
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			nuevaCompra.setEstado(1);
			Compras objSalida = compraService.save(nuevaCompra);
		    detalle.setCompras(nuevaCompra);
		    detalle.setProducto(id);
		    pedido.setDetalle(nuevaCompra);
		    pedido.setUsuario(id.getUsuario());
		    nuevaCompra.setMonto(id.getPrecio());
		    nuevaCompra.setNombreProducto(id.getNombre());
		    detalleService.save(detalle);
		    pedidoService.save(pedido);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_COMPRA_EXITOSA );
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return salida;

  }
	 @GetMapping("/buscarUsuario/{nombre}")
	    public ResponseEntity<Usuario> getByNombreUsuario(@PathVariable("nombre") String nombre){
	        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nombre);
	        
	        return new ResponseEntity(usuario, HttpStatus.OK);
	    }
	 
	 

	 @GetMapping(value = "/listaComprasByUsuario")
		@ResponseBody
		public ResponseEntity<List<Compras>> listaComprasByUsuario(int idUsuario) {
			List<Compras> lista = compraService.listaComprasPorUsuario(idUsuario);
			return ResponseEntity.ok(lista);
		}
	 
	 @GetMapping(value = "/listaPedidoByUsuario")
		@ResponseBody
		public ResponseEntity<List<Pedido>> listaPedidoByUsuario(int idUsuario) {
			List<Pedido> listaPedido = pedidoService.listaPedidoPorUsuario(idUsuario);
			return ResponseEntity.ok(listaPedido);
		}
	 
	 @PutMapping("/actualiza")
		@ResponseBody
		public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Compras obj) {
			Map<String, Object> salida = new HashMap<>();
			try {
				if (obj.getIdCompras() == 0) {
					salida.put("mensaje", "El ID del Docente debe ser diferente cero");
					return ResponseEntity.ok(salida);
				}
				Compras objSalida = compraService.insertaActualizaDocente(obj);
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
  
	 @GetMapping(value = "/listaDetallePorId")
		@ResponseBody
		public ResponseEntity<List<DetalleCompras>> lista(int idCompras) {
			List<DetalleCompras> lista = detalleService.lista(idCompras);
			return ResponseEntity.ok(lista);
		}
	 
	
	
	
}
