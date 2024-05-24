package game.project.gamoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import game.project.gamoo.models.Categorie;
import game.project.gamoo.services.CategorieRepository;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/categories")
public class CategorieController {

	@Autowired
	private CategorieRepository categorieRepository;

	// Get all categories
	@GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Categorie> getAllCategories() {
		System.out.println("Fetching all categories");
		return categorieRepository.findAll();
	}

	// Get a single category by ID
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Categorie> getCategoryById(@PathVariable("id") int id) {
		System.out.println("Fetching category with ID: " + id);
		return categorieRepository.findById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Create a new category
	@PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Categorie> createCategory(@Valid @RequestBody Categorie categorie) {
		System.out.println("Creating category: " + categorie.getNom());
		Categorie savedCategorie = categorieRepository.save(categorie);
		return ResponseEntity.ok(savedCategorie);
	}

	// Update an existing category
	@PutMapping(path = "/{id}")
	public ResponseEntity<Categorie> updateCategory(@Valid @RequestBody Categorie categorie,
			@PathVariable("id") int id) {
		System.out.println("Updating category with ID: " + id);
		if (!categorieRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categorie.setId(id);
		Categorie updatedCategorie = categorieRepository.save(categorie);
		return ResponseEntity.ok(updatedCategorie);
	}

	// Delete a category
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id) {
		System.out.println("Deleting category with ID: " + id);
		if (!categorieRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categorieRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
