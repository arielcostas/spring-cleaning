package dev.costas.librosautor.infra.persistors;

import dev.costas.librosautor.adapter.persist.AutorPersistor;
import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.infra.neo.dao.AutorNeoRepository;
import dev.costas.librosautor.infra.neo.entity.AutorNeo;
import org.springframework.context.annotation.Profile;
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
		return autorNeoRepository
				.findPage(limit, page * limit)
				.stream()
				.map(AutorNeo::to)
				.toList();
	}

	@Override
	public Autor findById(long id) {
		return autorNeoRepository
				.findById(id)
				.map(AutorNeo::to)
				.orElseThrow();
	}

	@Override
	public Autor persist(Autor autor) {
		return autorNeoRepository.save(AutorNeo.from(autor)).to();
	}
}
