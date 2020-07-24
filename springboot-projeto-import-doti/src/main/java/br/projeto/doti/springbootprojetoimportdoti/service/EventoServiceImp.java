package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.projeto.doti.springbootprojetoimportdoti.dao.EventoRepo;
import br.projeto.doti.springbootprojetoimportdoti.model.Evento;

@Component
public class EventoServiceImp implements IEventoService {

    @Autowired
    EventoRepo repo;

    @Override
    public List<Evento> ListarEventosEntreDatas(String data1, String data2) {
        return repo.findEventoBetweenDate(data1, data2);
    }

    @Override
    public List<Table> ContarEventosPorDescricaoEntreDatas(String data1, String data2) {
        return repo.countByDescricaEventosBetweenDate(data1, data2);
    }

    @Override
    public List<Evento> ContarEventosDataEspecifica(String data) {
        return repo.countByDescricaEventosEspecificDate(data);
    }
}