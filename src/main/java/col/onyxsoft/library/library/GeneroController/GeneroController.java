package col.onyxsoft.library.library.GeneroController;

import col.onyxsoft.library.library.Genero;
import col.onyxsoft.library.library.GeneroService.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/genero")
public class GeneroController {

    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping()
    private ResponseEntity<List<Genero>> getGenero(){
        return ResponseEntity.ok(generoService.getAllGenero());
    }

    @GetMapping("/getbyid/{id_genero}")
    public ResponseEntity<Object>EncontrarPorId(@PathVariable int id_genero){
        return this.generoService.getGeneroById(id_genero);
    }
}
