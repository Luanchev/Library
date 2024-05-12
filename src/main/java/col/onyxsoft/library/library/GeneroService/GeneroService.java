package col.onyxsoft.library.library.GeneroService;

import col.onyxsoft.library.library.Genero;
import col.onyxsoft.library.library.GeneroRepository.GeneroRepository;
import col.onyxsoft.library.library.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class GeneroService {

    HashMap<String, Object> datos;

    private final GeneroRepository generoRepository;


    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    //traemos todos los generos
    @Autowired
    public List<Genero>getAllGenero(){
        return generoRepository.findAll();
    }

   public ResponseEntity<Object>getGeneroById(int id_genero){
        Optional<Genero>generoGuardado = generoRepository.findById(id_genero);
        datos = new HashMap<>();
        if (generoGuardado.isPresent()){
            Genero genero = generoGuardado.get();
            datos.put("data", genero);
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>("No se encuentra ningun genero por el id", HttpStatus.NOT_FOUND);
        }
    }


}
