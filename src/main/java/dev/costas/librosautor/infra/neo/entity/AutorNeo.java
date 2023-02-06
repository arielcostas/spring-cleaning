package dev.costas.librosautor.infra.neo.entity;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.core.domain.Libro;
import jakarta.persistence.OneToMany;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Objects;

@Node(primaryLabel = "Autor")
public class AutorNeo {
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;

	private String apellidos;

	private String nacionalidad;

	@Relationship(direction = Relationship.Direction.OUTGOING, type = "ESCRIBE")
	private List<LibroNeo> libros;

	public static AutorNeo from(Autor autor) {
		List<Libro> listaLibros = Objects.requireNonNullElse(autor.libros(), List.of());
		return new AutorNeo()
				.setId(autor.id())
				.setNombre(autor.nombre())
				.setApellidos(autor.apellidos())
				.setNacionalidad(autor.nacionalidad())
				.setLibros(listaLibros.stream().map(LibroNeo::from).toList());
	}

	public Autor to() {
		return new Autor(
				id,
				nombre,
				apellidos,
				nacionalidad,
				libros.stream().map(LibroNeo::to).toList()
		);
	}

	public AutorNeo() {
	}

	public Long getId() {
		return id;
	}

	public AutorNeo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public AutorNeo setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public AutorNeo setApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public AutorNeo setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
		return this;
	}

	public List<LibroNeo> getLibros() {
		return libros;
	}

	public AutorNeo setLibros(List<LibroNeo> libros) {
		this.libros = libros;
		return this;
	}
}
