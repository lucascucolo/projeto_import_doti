package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.ArrayList;
import java.util.Date;
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
    public List<String> ListarHostnameEventoData(String data1, String data2) {
        List<String[]> lista = (List<String[]>) repo.findHostnameEventoData(data1, data2);
        List<String> lista2 = new ArrayList<String>();


        for (int i = 0; i < lista.size() ; i++) {
//            String[] varLista = lista.get(i).split(",");
            String equipamento = "equipamento:"+lista.get(i)[0];
            String alarme = "alarme:"+lista.get(i)[1];
            String data = "data:"+lista.get(i)[2];
            lista2.add(equipamento+","+alarme+","+data);
        }
        return lista2;
     
    }

    @Override
    public List<Evento> ListarEventosPorDatas(Date dataini, Date datafim) {
        return repo.findByDataevtBetween(dataini, datafim);
    }


    

}