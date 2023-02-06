package dev.costas.librosautor.infra.neo.dao;

import dev.costas.librosautor.infra.neo.entity.AutorNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface AutorNeoRepository extends Neo4jRepository<AutorNeo, Long> {
	@Query("MATCH (a:Autor) RETURN a ORDER BY a.id SKIP $skip LIMIT $limit")
	List<AutorNeo> findPage(int skip, int limit);
}
