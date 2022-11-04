package br.com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Filme;

public interface RepositoryFilme extends JpaRepository<Filme, Integer>{

}