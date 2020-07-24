package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.List;


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
    public List<?> ContarEventosPorDescricaoEntreDatas(String data1, String data2) {
        return repo.countByDescricaEventosBetweenDate(data1, data2);
    }

    @Override
    public List<?> ListarHostnameEventoData(String data1, String data2) {
        return repo.findHostnameEventoData(data1, data2);
    }


}