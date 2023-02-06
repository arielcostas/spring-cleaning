package dev.costas.librosautor.adapter.persist;

import dev.costas.librosautor.core.domain.Autor;

import java.util.List;

public interface AutorPersistor {
	List<Autor> findAll(int limit, int page);

	Autor persist(Autor autor);
}
