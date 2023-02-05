package dev.costas.librosautor.infra.entity;

import dev.costas.librosautor.core.domain.Libro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LibroJPA {
	@Id
	private Long id;

	private String titulo;

	private String isbn;

	@ManyToOne
	private AutorJPA autor;

	public LibroJPA() {
	}

	public static LibroJPA from(Libro libro) {
		return new LibroJPA()
				.setId(libro.id())
				.setTitulo(libro.titulo())
				.setIsbn(libro.isbn())
				.setAutor(AutorJPA.from(libro.autor()));
	}

	public Libro to() {
		return new Libro(
				id,
				titulo,
				isbn,
				autor.to()
		);
	}

	public Long getId() {
		return id;
	}

	public LibroJPA setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitulo() {
		return titulo;
	}

	public LibroJPA setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public String getIsbn() {
		return isbn;
	}

	public LibroJPA setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public AutorJPA getAutor() {
		return autor;
	}

	public LibroJPA setAutor(AutorJPA autor) {
		this.autor = autor;
		return this;
	}
}
