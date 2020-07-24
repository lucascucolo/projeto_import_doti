package br.projeto.doti.springbootprojetoimportdoti.dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.projeto.doti.springbootprojetoimportdoti.model.Evento;

public interface EventoRepo extends CrudRepository<Evento, Integer>{

    public List<Evento> findByDataevtBetween(Date dataini, Date datafim);
    
@Query(value = "select equip.hostname,itmn_alarme.nome,itmn_evento.dataevt from itmn_evento inner join itmn_equipamento as equip on equip.id_equip=itmn_evento.id_equip inner join itmn_alarme on itmn_alarme.id_alarme=itmn_evento.id_alarme where itmn_evento.dataevt BETWEEN STR_TO_DATE( ?1, '%d-%m-%Y') AND STR_TO_DATE( ?2 , '%d-%m-%Y') order by equip.hostname, itmn_alarme.nome, itmn_evento.dataevt;", nativeQuery = true)
 public List<String[]> findHostnameEventoData(String data1, String data2);
 
 @Query(value = "select itmn_alarme.descricao, COUNT(itmn_alarme.id_alarme) AS total from itmn_evento INNER JOIN itmn_alarme ON itmn_evento.id_alarme = itmn_alarme.id_alarme WHERE itmn_evento.dataevt BETWEEN STR_TO_DATE( ?1 , '%d-%m-%Y') AND STR_TO_DATE( ?2 , '%d-%m-%Y') GROUP BY itmn_alarme.id_alarme", nativeQuery = true)
 public List<?> countByDescricaEventosBetweenDate(String data1, String data2); 

 @Query(value = "select itmn_evento.* from itmn_evento where dataevt between STR_TO_DATE( ?1 , '%d-%m-%Y') AND STR_TO_DATE( ?2 , '%d-%m-%Y');", nativeQuery = true)
 public List<Evento> findEventoBetweenDate(String data1, String data2);
}