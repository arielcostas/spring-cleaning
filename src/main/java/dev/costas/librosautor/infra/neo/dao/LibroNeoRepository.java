package dev.costas.librosautor.infra.neo.dao;

import dev.costas.librosautor.infra.neo.entity.LibroNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LibroNeoRepository extends Neo4jRepository<LibroNeo, Long> {
}
