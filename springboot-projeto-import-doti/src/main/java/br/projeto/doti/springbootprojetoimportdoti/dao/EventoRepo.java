package br.projeto.doti.springbootprojetoimportdoti.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.projeto.doti.springbootprojetoimportdoti.model.Evento;

public interface EventoRepo extends CrudRepository<Evento, Integer>{

    
@Query(value = "select itmn_alarme.descricao, COUNT(itmn_alarme.id_alarme) from itmn_evento INNER JOIN itmn_alarme ON itmn_evento.id_alarme = itmn_alarme.id_alarme WHERE itmn_evento.dataevt = STR_TO_DATE( ?1 , '%d-%m-%Y') GROUP BY itmn_alarme.id_alarme", nativeQuery = true)
 public List<Evento> countByDescricaEventosEspecificDate(String data);
 
 @Query(value = "select itmn_alarme.descricao, COUNT(itmn_alarme.id_alarme) AS total from itmn_evento INNER JOIN itmn_alarme ON itmn_evento.id_alarme = itmn_alarme.id_alarme WHERE itmn_evento.dataevt BETWEEN STR_TO_DATE( ?1 , '%d-%m-%Y') AND STR_TO_DATE( ?2 , '%d-%m-%Y') GROUP BY itmn_alarme.id_alarme", nativeQuery = true)
 public List<Table> countByDescricaEventosBetweenDate(String data1, String data2); 

 @Query(value = "select itmn_evento.* from itmn_evento where dataevt between STR_TO_DATE( ?1 , '%d-%m-%Y') AND STR_TO_DATE( ?2 , '%d-%m-%Y');", nativeQuery = true)
 public List<Evento> findEventoBetweenDate(String data1, String data2);
}