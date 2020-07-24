package br.projeto.doti.springbootprojetoimportdoti.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.doti.springbootprojetoimportdoti.model.Evento;
import br.projeto.doti.springbootprojetoimportdoti.model.Usuario;
import br.projeto.doti.springbootprojetoimportdoti.service.IEventoService;
import br.projeto.doti.springbootprojetoimportdoti.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

	@Autowired
	private IUsuarioService service;

	@Autowired
	private IEventoService eventService;

	@PostMapping("/login")
	public ResponseEntity <Usuario> login(@RequestBody Usuario userIncomplete) {
		Usuario userFinded = service.loginPorEmailOuRacf(userIncomplete);
		if (userFinded != null) {
			return ResponseEntity.ok(userFinded);
		}
		return ResponseEntity.status(404).build(); // usuário não existe
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}


	@GetMapping("/eventos/datas/{data1}/{data2}")
    public ResponseEntity<List<Evento>> ListarEventosEntreDatas(@PathVariable String data1, @PathVariable String data2) {
        return ResponseEntity.ok(eventService.ListarEventosEntreDatas(data1, data2) );
        
	}
	
	@GetMapping("/eventos/count/datas/{data1}/{data2}")
    public ResponseEntity<List<?>> ContarEventosPorDescricaoEntreDatas(@PathVariable String data1, @PathVariable String data2) {
        return ResponseEntity.ok(eventService.ContarEventosPorDescricaoEntreDatas(data1, data2) );
        
	}
	
	@GetMapping("/eventos/hostname/datas/{data1}/{data2}")
    public ResponseEntity<List<Evento>> ListarHostnameEventoData(@PathVariable String data1,@PathVariable String data2) throws ParseException{
	//	List<String> lista = eventService.ListarHostnameEventoData(data1, data2);
		System.out.println(data1 + " : " + data2);
		Date dataini = new SimpleDateFormat("yyyy-mm-dd").parse(data1);
		Date datafim = new SimpleDateFormat("yyyy-mm-dd").parse(data2);
		List<Evento> lista = eventService.ListarEventosPorDatas(dataini, datafim);

		return ResponseEntity.ok(lista) ;
        
	}


}
