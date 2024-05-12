package col.onyxsoft.library.library.LibroController;

import col.onyxsoft.library.library.Libro;
import col.onyxsoft.library.library.libroService.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/library")

public class LibroController {
    @Autowired
    private LibroService libroService;

    //exponemos todos los libros con el metodo GET
    @GetMapping
    public ResponseEntity<List<Libro>> getLibros(){
        return ResponseEntity.ok(libroService.getLibros());
    }

    //exponemos el libro por el id_libro
   @GetMapping("/getbyid/{id_libro}")
    public ResponseEntity<Object>EncontrarPorId(@PathVariable int id_libro){
        return this.libroService.getLibroById(id_libro);
    }

   //exponemos el metodo POST
    @PostMapping("/registrarlibro/")
    public  ResponseEntity<Object> registrarLibro(@RequestBody Libro libro){
        return this.libroService.createLibro(libro);
    }
    //MetodoPut
    @PutMapping("/actualizarlibro/")
    public ResponseEntity<Object> actualizarLibro(@RequestBody Libro libro){
        return this.libroService.createLibro(libro);
    }
    @DeleteMapping(path = "/eliminarlibro/{id_libro}")
    public ResponseEntity<Object> eliminarLibro(@PathVariable("id_libro") int id_libro){
        return this.libroService.deleteLibro((id_libro));
    }



}
