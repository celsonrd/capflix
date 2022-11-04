package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.model.Filme;
import br.com.start.model.dto.RequestDTO;
import br.com.start.model.dto.ResponseDTO;
import br.com.start.repository.RepositoryFilme;

@Service
public class ServiceFilme {
	
	@Autowired
	private RepositoryFilme repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public ResponseDTO criar(RequestDTO requestDTO) {
		
		Filme filme = mapper.map(requestDTO, Filme.class);
		
		Filme filmeBanco = repository.save(filme);
		
		ResponseDTO responseDTO = mapper.map(filmeBanco, ResponseDTO.class);
		
		return responseDTO;
	}
	
	public boolean alterar(Integer id, RequestDTO requestDTO) {
		Optional<Filme> optional = repository.findById(id);
		
		if(optional.isEmpty()) {
			return false;	
		}
		
		Filme filmeBanco = optional.get();
		
		mapper.map(requestDTO, filmeBanco);
		
		repository.save(filmeBanco);
		
		return true;
	}
	
	public ResponseDTO getOne(Integer id) {
		Optional<Filme> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Filme filmeBanco = optional.get();
		
		ResponseDTO responseDTO = mapper.map(filmeBanco, ResponseDTO.class);
		
		return responseDTO;
	}
	
	public boolean excluir(Integer id) {
		if(!repository.existsById(id)) {
			return false;
			
		}
		
		repository.deleteById(id);
		return true;
	}
	
	public List<ResponseDTO> listar(){
		List<Filme> postagens = repository.findAll();
		
		List<ResponseDTO> responseDTO = mapper.map(postagens, new TypeToken<List<ResponseDTO>> () {}.getType());
		
		return responseDTO;	
	}

}
