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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
   
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getBasicList() {

        List<MovieBasicDTO> movies = movieService.getBasicList();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/alldetails")
    public ResponseEntity<List<MovieDTO>> getAllDetails() {

        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) {
        MovieDTO savedMovie = movieService.save(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> modify(@PathVariable String id, @RequestBody MovieDTO movieDTO) {
        MovieDTO editedMovie = movieService.modify(id, movieDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{movieId}/character/{charId}")
    public ResponseEntity<Void> addCharacter(@PathVariable String movieId, @PathVariable String charId) {
        movieService.addCharacter(movieId, charId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    
}
