package dev.costas.librosautor.adapter.service;

import dev.costas.librosautor.adapter.persist.AutorPersistor;
import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.core.usecase.ListAutoresUseCase;
import dev.costas.librosautor.core.usecase.NuevoAutorUseCase;
import dev.costas.librosautor.io.ListAutoresOutput;
import dev.costas.librosautor.io.NuevoAutorInput;
import dev.costas.librosautor.io.PageParams;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements NuevoAutorUseCase, ListAutoresUseCase {
	private final AutorPersistor autorPersistor;

	public AutorService(AutorPersistor autorPersistor) {
		this.autorPersistor = autorPersistor;
	}

	@Override
	public Autor nuevoAutor(NuevoAutorInput input) {
		var autor = new Autor(null, input.nombre(), input.apellidos(), input.nacionalidad(), null);
		return autorPersistor.persist(autor);
	}

	@Override
	public ListAutoresOutput listAutores(PageParams pageParams) {
		var limit = pageParams.getLimit();
		if (limit > 100) limit = 100;
		if (limit < 1) limit = 1;

		var page = pageParams.getPage();
		if (page < 0) page = 0;

		List<Autor> result =autorPersistor.findAll(limit, page);

		return new ListAutoresOutput(
				result.size(),
				result
		);
	}
}
