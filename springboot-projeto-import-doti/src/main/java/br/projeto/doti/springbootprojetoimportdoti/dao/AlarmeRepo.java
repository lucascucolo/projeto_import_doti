package br.projeto.doti.springbootprojetoimportdoti.dao;

import org.springframework.data.repository.CrudRepository;

import br.projeto.doti.springbootprojetoimportdoti.model.Alarme;

public interface AlarmeRepo extends CrudRepository<Alarme, Integer>{

}