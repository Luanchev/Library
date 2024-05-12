package col.onyxsoft.library.library;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name= "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer id_libro;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "anio_publicacion")
    private Date anio_publicacion;

    //hacemos la relacion de id_genero_fk
    @ManyToOne
    @JoinColumn(name = "id_genero_fk")
    private Genero genero;

    public Libro() {
    }

    public Libro(Integer id_libro, String titulo, String autor, Date anio_publicacion, Genero genero) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.genero = genero;
    }

    public Libro(String titulo, String autor, Date anio_publicacion, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.genero = genero;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Date anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
