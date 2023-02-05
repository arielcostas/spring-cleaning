package dev.costas.librosautor.core.domain;

import java.util.List;

public record Autor(
		Long id,
		String nombre,
		String apellidos,
		String nacionalidad,
		List<Libro> libros
) {
}
