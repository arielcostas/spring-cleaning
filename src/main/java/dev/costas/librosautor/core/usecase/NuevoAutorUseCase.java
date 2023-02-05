package dev.costas.librosautor.core.usecase;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.io.NuevoAutorInput;

public interface NuevoAutorUseCase {
	Autor nuevoAutor(NuevoAutorInput input);
}
