package dev.costas.librosautor.infra.neo.dao;

import dev.costas.librosautor.infra.neo.entity.AutorNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AutorNeoRepository extends Neo4jRepository<AutorNeo, Long> {
}
