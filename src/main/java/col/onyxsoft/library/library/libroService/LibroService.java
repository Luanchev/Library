package col.onyxsoft.library.library.libroService;

import col.onyxsoft.library.library.Genero;
import col.onyxsoft.library.library.GeneroRepository.GeneroRepository;
import col.onyxsoft.library.library.Libro;
import col.onyxsoft.library.library.libroRepository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
public class LibroService {
    HashMap<String, Object> datos;

    private final LibroRepository libroRepository;
    private final GeneroRepository generoRepository;


    public LibroService(LibroRepository libroRepository, GeneroRepository generoRepository) {
        this.libroRepository = libroRepository;
        this.generoRepository = generoRepository;
    }

    //traemos todos los libros
    @Autowired
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    //Encontramos los libros por el Id
    public ResponseEntity<Object>getLibroById(int id_libro) {
        Optional<Libro> libroGuardado = libroRepository.findById(id_libro);
        datos = new HashMap<>();
        if (libroGuardado.isPresent()) {
            Libro libro = libroGuardado.get();
            datos.put("data", libro);
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>("No se encuentra ningun libro por el id", HttpStatus.NOT_FOUND);
        }

    }

    // este servicio lo podemos usar para crear y actualizar los libros
    public ResponseEntity<Object> createLibro(Libro libro) {
        //antes de crear un nuevo libro debemos de validar si el producto ya existe
        Optional<Libro> res = libroRepository.findLibroByTitulo(libro.getTitulo());
        datos = new HashMap<>();

        //aqui validamos que el libro exista con el titulo
        if (res.isPresent() && libro.getId_libro() == null) {
            datos.put("error", true);
            datos.put("message", "Ya existe un libro con ese titulo");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        if (libro.getId_libro() != null) {
            datos.put("message", "se actualizo con exito");
        }
        //aqui validamos que el genero no este vacio
        if(libro.getGenero() == null){
            datos.put("error", "El ID genero no puede estar vacio");
        }
        //buscamos que el genero indicado si este en la tabla genero
        Optional<Genero> generoOpcional = generoRepository.findById(libro.getGenero().getId_genero());
        if (generoOpcional.isEmpty()){
            datos.put("error", true);
            datos.put("message", "El genero asociado al libro no existe debe de ser del 1 al 5");
        }

        libro.setGenero(generoOpcional.orElse(new Genero()));
        libroRepository.save(libro);
        datos.put("data", libro);
        datos.put("message", "se guardo con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    //servicio para eliminar libros
    public ResponseEntity<Object>deleteLibro(int id_libro){
        datos = new HashMap<>();
        //validamos que el id que estamos poniendo si exista
        if (!libroRepository.existsById(id_libro) ){
            datos.put("error", true);
            datos.put("message", "No existe un libro con el id : " + id_libro);
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.NOT_FOUND
            );
        }else {
            libroRepository.deleteById(id_libro);
            datos.put("message", "El libro fue eliminado con exito");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.ACCEPTED
            );
        }
    }




}