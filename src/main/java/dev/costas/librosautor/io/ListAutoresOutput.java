package dev.costas.librosautor.io;

import dev.costas.librosautor.core.domain.Autor;

import java.util.List;

public record ListAutoresOutput(
		int total,
		List<Autor> autores
) {
}
