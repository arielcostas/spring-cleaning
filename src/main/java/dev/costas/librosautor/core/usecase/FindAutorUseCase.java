package dev.costas.librosautor.core.usecase;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.infra.params.FindAutorOutput;

public interface FindAutorUseCase {
	FindAutorOutput findAutor(Long id);
}
