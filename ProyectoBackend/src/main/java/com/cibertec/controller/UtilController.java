package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Categoria;
import com.cibertec.service.CategoriaService;

@RestController
@RequestMapping("/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listaCategoria")
	@ResponseBody
	public List<Categoria> listaCategoria() {
		return categoriaService.listaCategoria();
	}
	
	
}
