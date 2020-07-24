package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.List;

import javax.persistence.Table;

import br.projeto.doti.springbootprojetoimportdoti.model.Evento;

public interface IEventoService {
    public List<Evento> ListarEventosEntreDatas(String data1, String data2);
    public List<Table> ContarEventosPorDescricaoEntreDatas(String data1, String data2); 
    public List<Evento> ContarEventosDataEspecifica(String data); 
}