/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.entities.controllers;


import disney.challenge.dto.MovieBasicDTO;
import disney.challenge.dto.MovieDTO;
import disney.challenge.service.MovieService;
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
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAll(){
        List<MovieBasicDTO>characters= movieService.getAllMovies();
        return ResponseEntity.ok().body(characters);
    }
    
    
    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO character){        
        
        MovieDTO characterSave= movieService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSave);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}
