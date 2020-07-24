package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.List;

import br.projeto.doti.springbootprojetoimportdoti.model.Usuario;

public interface IUsuarioService {
    public Usuario loginPorEmailOuRacf(Usuario usuario);
    public List<Usuario> listarTodos();
    public List<Usuario> listarUsurios();
}