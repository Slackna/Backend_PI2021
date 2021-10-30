package com.cibertec.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.entity.Usuario;

@Service
@Transactional
public interface UsuarioService {
	
	public abstract List<Usuario> listaUsuario();
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract List<Usuario> listaVendedor();
	public abstract Usuario insertaActualizaVendedor(Usuario obj);
	Optional<Usuario> getByNombreUsuario(String nombreUsuario);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
	void save(Usuario usuario);
    
}
