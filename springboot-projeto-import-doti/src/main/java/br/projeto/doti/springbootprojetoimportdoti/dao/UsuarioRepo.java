package br.projeto.doti.springbootprojetoimportdoti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.projeto.doti.springbootprojetoimportdoti.model.Usuario;


public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{

	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByEmailOrRacf(String email, String racf);

	@Query(value = "select itmn_usuario.* from itmn_usuario", nativeQuery = true)
	public List<Usuario> findUsuarios();
	
}