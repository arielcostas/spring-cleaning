package dev.costas.librosautor.core.usecase;

import dev.costas.librosautor.io.ListAutoresOutput;
import dev.costas.librosautor.io.PageParams;

public interface ListAutoresUseCase {
	ListAutoresOutput listAutores(PageParams pageParams);
}
