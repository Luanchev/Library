package col.onyxsoft.library.library.libroRepository;

import col.onyxsoft.library.library.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {



    //este lo necesitamos para validar si el libro ya existe
    Optional<Libro>findLibroByTitulo(String titulo);

}
