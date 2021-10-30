package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Usuario;
import com.cibertec.repository.UsuarioRepository;


@Service
public class UsuarioServicelmpl  implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}
  
	@Override
	public List<Usuario> listaVendedor() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaActualizaVendedor(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	 public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
	        return repository.findByNombreUsuario(nombreUsuario);
	    }
	@Override
	    public boolean existsByNombreUsuario(String nombreUsuario){
	        return repository.existsByNombreUsuario(nombreUsuario);
	    }
	
	@Override
	    public boolean existsByEmail(String email){
	        return repository.existsByEmail(email);
	    }
	@Override
	    public void save(Usuario usuario){
	        repository.save(usuario);
	    }
	

}
