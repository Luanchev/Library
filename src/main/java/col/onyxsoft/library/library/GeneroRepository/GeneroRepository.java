package col.onyxsoft.library.library.GeneroRepository;

import col.onyxsoft.library.library.Genero;
import col.onyxsoft.library.library.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
