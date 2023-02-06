package dev.costas.librosautor.infra.jpa.dao;

import dev.costas.librosautor.infra.jpa.entity.LibroJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroJpaRepository extends JpaRepository<LibroJPA, Long> {
}
