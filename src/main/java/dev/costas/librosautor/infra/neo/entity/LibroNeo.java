package dev.costas.librosautor.infra.neo.entity;

import dev.costas.librosautor.core.domain.Libro;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(primaryLabel = "Libro")
public class LibroNeo {
	@Id
	@GeneratedValue
	private Long id;

	private String titulo;

	private String isbn;

	@Relationship(type="ESCRIBE", direction = Relationship.Direction.INCOMING)
	private AutorNeo autor;

	public LibroNeo() {
	}

	public static LibroNeo from(Libro libroNeo) {
		return new LibroNeo()
				.setId(libroNeo.id())
				.setTitulo(libroNeo.titulo())
				.setIsbn(libroNeo.isbn())
				.setAutor(AutorNeo.from(libroNeo.autor()));
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

	public LibroNeo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitulo() {
		return titulo;
	}

	public LibroNeo setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public String getIsbn() {
		return isbn;
	}

	public LibroNeo setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public AutorNeo getAutor() {
		return autor;
	}

	public LibroNeo setAutor(AutorNeo autor) {
		this.autor = autor;
		return this;
	}
}
