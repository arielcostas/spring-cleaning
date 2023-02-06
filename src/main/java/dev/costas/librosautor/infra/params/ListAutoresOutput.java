package dev.costas.librosautor.infra.params;

import dev.costas.librosautor.core.domain.Autor;

import java.util.List;

public record ListAutoresOutput(
		int total,
		List<Autor> autores
) {
}
