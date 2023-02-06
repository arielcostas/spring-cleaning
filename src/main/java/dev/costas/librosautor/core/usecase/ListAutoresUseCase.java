package dev.costas.librosautor.core.usecase;

import dev.costas.librosautor.infra.params.ListAutoresOutput;
import dev.costas.librosautor.infra.params.PageParams;

public interface ListAutoresUseCase {
	ListAutoresOutput listAutores(PageParams pageParams);
}
