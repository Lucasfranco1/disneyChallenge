/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.entities.controllers;

import disney.challenge.dto.GenderDTO;
import disney.challenge.service.GenderService;
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
@RequestMapping("/genders")
public class GenderController {
    
    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<GenderDTO>> getALL() {

        List<GenderDTO> genres = genderService.getAllGenders();
        return ResponseEntity.ok().body(genres);
    }

    @PostMapping
    public ResponseEntity<GenderDTO> save(@RequestBody GenderDTO genderDTO) {
        GenderDTO savedGender = genderService.save(genderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGender);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> modify(@PathVariable String id, @RequestBody GenderDTO genderDTO) {
        GenderDTO editedGender = genderService.modify(id, genderDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedGender);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        genderService.deleteGenderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
