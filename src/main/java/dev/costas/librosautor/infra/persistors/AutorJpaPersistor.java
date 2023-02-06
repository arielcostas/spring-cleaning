package dev.costas.librosautor.infra.persistors;

import dev.costas.librosautor.adapter.persist.AutorPersistor;
import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.infra.jpa.dao.AutorJpaRepository;
import dev.costas.librosautor.infra.jpa.entity.AutorJPA;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
public class AutorJpaPersistor implements AutorPersistor {
	private final AutorJpaRepository autorJpaRepository;

	public AutorJpaPersistor(AutorJpaRepository autorJpaRepository) {
		this.autorJpaRepository = autorJpaRepository;
	}

	public List<Autor> findAll(int limit, int page) {
		Pageable pageable = Pageable.ofSize(limit).withPage(page);
		return autorJpaRepository
				.findAll(pageable)
				.stream()
				.map(AutorJPA::to)
				.toList();
	}

	@Override
	public Autor findById(long id) {
		return autorJpaRepository
				.findById(id)
				.map(AutorJPA::to)
				.orElseThrow();
	}

	public Autor persist(Autor autor) {
		return autorJpaRepository.save(AutorJPA.from(autor)).to();
	}
}
