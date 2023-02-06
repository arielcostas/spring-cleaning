package dev.costas.librosautor.infra.jpa.dao;

import dev.costas.librosautor.infra.jpa.entity.AutorJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorJpaRepository extends JpaRepository<AutorJPA, Long> {
}
