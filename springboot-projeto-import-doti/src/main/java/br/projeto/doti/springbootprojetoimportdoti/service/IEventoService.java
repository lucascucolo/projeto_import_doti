package br.projeto.doti.springbootprojetoimportdoti.service;

import java.util.Date;
import java.util.List;



import br.projeto.doti.springbootprojetoimportdoti.model.Evento;

public interface IEventoService {
    public List<Evento> ListarEventosEntreDatas(String data1, String data2);
    public List<?> ContarEventosPorDescricaoEntreDatas(String data1, String data2); 
    public List<String> ListarHostnameEventoData(String data1, String data2);
    public List<Evento> ListarEventosPorDatas(Date dataini, Date datafim);
}