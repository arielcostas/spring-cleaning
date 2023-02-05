package dev.costas.librosautor.infra.dao;

import dev.costas.librosautor.infra.entity.AutorJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorJPA, Long> {
}
