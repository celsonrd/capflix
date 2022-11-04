package br.com.start.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.model.dto.RequestDTO;
import br.com.start.model.dto.ResponseDTO;
import br.com.start.service.ServiceFilme;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/filme")
public class ControllerFilme {
	
	@Autowired
	private ServiceFilme service;

	@PostMapping
	public ResponseDTO criar(@Valid @RequestBody RequestDTO requestDTO) {	
		log.info("Save: {}", requestDTO );
		return service.criar(requestDTO);
	}
	
	@PutMapping("id/{id}")
	public boolean alterar(@PathVariable("id") Integer id, @RequestBody RequestDTO requestDTO) {		
		log.info("Alter: Registro No = {}");
		return service.alterar(id, requestDTO);
	}
	
	@GetMapping("id/{id}")
	public ResponseDTO getOne(@PathVariable("id") Integer id) {
		log.info("pegarUm : ID No{} ", id);		
		return service.getOne(id);	
		
	}
	
	@DeleteMapping("id/{id}")
	public boolean excluir(@PathVariable("id") Integer id) {	
		if(!service.excluir(id)) {
			log.info("Erro: Problema ao Excluir o registro No = {}", id );
			return false;
		}
			log.info("Sucesso: Registro No = {} Excluido com sucesso", id );
			return true;	
	}
	
	@GetMapping
	public List<ResponseDTO> listar(){
		log.info("Listar Todos");
		
		return service.listar();
	}

}