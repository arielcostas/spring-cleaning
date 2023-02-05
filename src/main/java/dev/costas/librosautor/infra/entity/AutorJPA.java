package dev.costas.librosautor.infra.entity;

import dev.costas.librosautor.core.domain.Autor;
import dev.costas.librosautor.core.domain.Libro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class AutorJPA {
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;

	private String apellidos;

	private String nacionalidad;

	@OneToMany(mappedBy = "autor")
	private List<LibroJPA> libros;

	public static AutorJPA from(Autor autor) {
		List<Libro> listaLibros = Objects.requireNonNullElse(autor.libros(), List.of());
		return new AutorJPA()
				.setId(autor.id())
				.setNombre(autor.nombre())
				.setApellidos(autor.apellidos())
				.setNacionalidad(autor.nacionalidad())
				.setLibros(listaLibros.stream().map(LibroJPA::from).toList());
	}

	public Autor to() {
		return new Autor(
				id,
				nombre,
				apellidos,
				nacionalidad,
				libros.stream().map(LibroJPA::to).toList()
		);
	}

	public AutorJPA() {
	}

	public Long getId() {
		return id;
	}

	public AutorJPA setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public AutorJPA setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public AutorJPA setApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public AutorJPA setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
		return this;
	}

	public List<LibroJPA> getLibros() {
		return libros;
	}

	public AutorJPA setLibros(List<LibroJPA> libros) {
		this.libros = libros;
		return this;
	}
}
