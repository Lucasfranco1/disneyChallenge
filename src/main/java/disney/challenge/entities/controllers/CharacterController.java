package disney.challenge.entities.controllers;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.service.CharacterService;
import disney.challenge.service.MovieService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {
 
    @Autowired
    private CharacterService characterService;
    @Autowired
    private MovieService movieService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {

        List<CharacterDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getDetailsById(@PathVariable String id) {
        CharacterDTO charDTO = this.characterService.getDetailById(id);
        return ResponseEntity.ok(charDTO);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Set<Long> movies,
            @RequestParam(required = false, defaultValue = "ASC") String order) {

        List<CharacterDTO> dtoList = this.characterService.getByFilters(name, age, movies, order);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO characterDTO) {
        CharacterDTO savedCharacter = characterService.save(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable String id, @RequestBody CharacterDTO characterDTO) {
        CharacterDTO result = this.characterService.modify(id, characterDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CharacterDTO> delete(@PathVariable String id) {
        this.characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable String id, @PathVariable String idMovie) {
        this.characterService.addMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable String id, @PathVariable String idMovie) {
        this.characterService.removeMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> addCharacter(@PathVariable String movieId, @PathVariable String characterId) {
        movieService.addCharacter(movieId, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{movieId}/gender/{genderId}")
    public ResponseEntity<Void> addGender(@PathVariable String movieId, @PathVariable String genderId) {
        movieService.addGender(movieId, genderId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
