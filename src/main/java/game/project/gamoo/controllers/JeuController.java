package game.project.gamoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.project.gamoo.models.Jeu;
import game.project.gamoo.services.JeuRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class JeuController {
	@Autowired
	private JeuRepository JeuRepository;

	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Jeu> getAll() {
		return JeuRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Jeu> getJeu(@PathVariable("id") int id) {
//		return JeuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid commande Id:" + id));
		Jeu jeu = JeuRepository.findById(id).orElse(null);
		if (jeu == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(jeu);

	}
	//Recherche by categ
	@GetMapping(path = "/category/{categoryId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Jeu>> getGamesByCategory(@PathVariable("categoryId") int categoryId) {
        List<Jeu> jeux = JeuRepository.findByCategorieId(categoryId);
        if (jeux.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jeux);
    }

	@PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Jeu> createJeu(@Valid @RequestBody Jeu jeu) {
		Jeu savedJeu = JeuRepository.save(jeu);
		return ResponseEntity.ok(savedJeu);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Jeu> edit(@Valid @RequestBody Jeu jeu, @PathVariable("id") int id) {
		if (!JeuRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		jeu.setId(id);
		Jeu updatedJeu = JeuRepository.save(jeu);
		return ResponseEntity.ok(updatedJeu);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") int id) {
		JeuRepository.deleteById(id);

	}

}
