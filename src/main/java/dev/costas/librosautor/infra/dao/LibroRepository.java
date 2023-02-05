package dev.costas.librosautor.infra.dao;

import dev.costas.librosautor.infra.entity.LibroJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroJPA, Long> {
}
