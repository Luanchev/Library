package col.onyxsoft.library.library;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name= "genero")
public class Genero  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer id_genero;
    @Column(name = "nombre")
    private String nombre;

    public Genero() {
    }

    public Genero(Integer id_genero, String nombre) {
        this.id_genero = id_genero;
        this.nombre = nombre;
    }

    public Genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
