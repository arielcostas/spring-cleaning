package dev.costas.librosautor.infra.controllers;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.core.usecase.ListAutoresUseCase;
import dev.costas.librosautor.io.ListAutoresOutput;
import dev.costas.librosautor.io.NuevoAutorInput;
import dev.costas.librosautor.core.usecase.NuevoAutorUseCase;
import dev.costas.librosautor.io.PageParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	private final NuevoAutorUseCase nuevoAutorUseCase;
	private final ListAutoresUseCase listAutoresUseCase;

	public AutorController(NuevoAutorUseCase nuevoAutorUseCase, ListAutoresUseCase listAutoresUseCase) {
		this.nuevoAutorUseCase = nuevoAutorUseCase;
		this.listAutoresUseCase = listAutoresUseCase;
	}

	@PostMapping("/autores")
	public ResponseEntity<Autor> nuevoAutor(
			@RequestBody NuevoAutorInput nuevoAutorInput
	) {
		return ResponseEntity.ok(nuevoAutorUseCase.nuevoAutor(nuevoAutorInput));
	}

	@GetMapping("/autores")
	public ResponseEntity<ListAutoresOutput> listAutores(
			PageParams pageParams
	) {
		return ResponseEntity.ok(listAutoresUseCase.listAutores(pageParams));
	}
}
