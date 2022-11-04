package br.com.start.model.dto;

import br.com.start.model.Genero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestDTO {

	private String nome;
	private String descricao;
	private String url;
	private Genero genero;
	
}
