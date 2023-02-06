package dev.costas.librosautor.infra.persistors;

import dev.costas.librosautor.adapter.persist.AutorPersistor;
import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.infra.jpa.entity.AutorJPA;
import dev.costas.librosautor.infra.neo.dao.AutorNeoRepository;
import dev.costas.librosautor.infra.neo.entity.AutorNeo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("neo")
public class AutorNeoPersistor implements AutorPersistor {
	private final AutorNeoRepository autorNeoRepository;

	public AutorNeoPersistor(AutorNeoRepository autorNeoRepository) {
		this.autorNeoRepository = autorNeoRepository;
	}

	@Override
	public List<Autor> findAll(int limit, int page) {
		Pageable pageable = Pageable.ofSize(limit).withPage(page);
		return autorNeoRepository
				.findAll(pageable)
				.stream()
				.map(AutorNeo::to)
				.toList();
	}

	@Override
	public Autor persist(Autor autor) {
		return autorNeoRepository.save(AutorNeo.from(autor)).to();
	}
}
