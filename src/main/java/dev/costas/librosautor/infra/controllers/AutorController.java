package dev.costas.librosautor.infra.controllers;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.core.usecase.FindAutorUseCase;
import dev.costas.librosautor.core.usecase.ListAutoresUseCase;
import dev.costas.librosautor.infra.params.FindAutorOutput;
import dev.costas.librosautor.infra.params.ListAutoresOutput;
import dev.costas.librosautor.infra.params.NuevoAutorInput;
import dev.costas.librosautor.core.usecase.NuevoAutorUseCase;
import dev.costas.librosautor.infra.params.PageParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutorController {
	private final NuevoAutorUseCase nuevoAutorUseCase;
	private final ListAutoresUseCase listAutoresUseCase;
	private final FindAutorUseCase findAutorUseCase;

	public AutorController(NuevoAutorUseCase nuevoAutorUseCase, ListAutoresUseCase listAutoresUseCase, FindAutorUseCase findAutorUseCase) {
		this.nuevoAutorUseCase = nuevoAutorUseCase;
		this.listAutoresUseCase = listAutoresUseCase;
		this.findAutorUseCase = findAutorUseCase;
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

	@GetMapping("/autores/{id}")
	public ResponseEntity<FindAutorOutput> getAutor(
			@PathVariable Long id
	) {
		return ResponseEntity.ok(findAutorUseCase.findAutor(id));
	}
}
