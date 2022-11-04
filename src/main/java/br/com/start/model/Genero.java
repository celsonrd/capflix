package br.com.start.model;

public enum Genero {
	
	ACAO("Ação"),
	AVENTURA("Aventura"),
	DRAMA("Drama"),
	COMEDIA("Comédia"),
	TERROR("Terror"),
	FICCAO("Ficção Cientifica"),
	ROMANCE("Romance");
	
	public final String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}
	
}
