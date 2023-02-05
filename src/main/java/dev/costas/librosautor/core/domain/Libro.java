package dev.costas.librosautor.core.domain;

public record Libro(
		Long id,
		String titulo,
		String isbn,
		Autor autor
) {
}
