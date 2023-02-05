package dev.costas.librosautor.adapter.persist;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.infra.dao.AutorRepository;
import dev.costas.librosautor.infra.entity.AutorJPA;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorPersistor {
	private final AutorRepository autorRepository;

	public AutorPersistor(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	public List<Autor> findAll(int limit, int page) {
		Pageable pageable = Pageable.ofSize(limit).withPage(page);
		return autorRepository
				.findAll(pageable)
				.stream()
				.map(AutorJPA::to)
				.toList();
	}

	public Autor persist(Autor autor) {
		return autorRepository.save(AutorJPA.from(autor)).to();
	}
}
