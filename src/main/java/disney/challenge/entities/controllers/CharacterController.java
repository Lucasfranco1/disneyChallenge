package disney.challenge.entities.controllers;

import disney.challenge.dto.CharacterBasicDTO;
import disney.challenge.dto.CharacterDTO;
import disney.challenge.service.CharacterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {
 
    @Autowired
    private CharacterService characterService;
    
    
    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){
        List<CharacterBasicDTO>characters= characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }
    
    
    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){        
        
        CharacterDTO characterSave= characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSave);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
