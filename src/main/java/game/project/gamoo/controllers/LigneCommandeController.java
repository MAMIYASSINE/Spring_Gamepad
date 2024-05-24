package game.project.gamoo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import game.project.gamoo.models.LigneCommande;
import game.project.gamoo.services.LigneCommandeRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/ligne-commandes")
public class LigneCommandeController {

	@Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LigneCommande> getAll() {
        return ligneCommandeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<LigneCommande> getLigneCommande(@PathVariable("id") int id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id).orElse(null);
        if (ligneCommande == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ligneCommande);
    }

    @PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<LigneCommande> createLigneCommande(@Valid @RequestBody LigneCommande ligneCommande) {
        LigneCommande savedLigneCommande = ligneCommandeRepository.save(ligneCommande);
        return ResponseEntity.ok(savedLigneCommande);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LigneCommande> editLigneCommande(@Valid @RequestBody LigneCommande ligneCommande, @PathVariable("id") int id) {
        if (!ligneCommandeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ligneCommande.setId(id);
        LigneCommande updatedLigneCommande = ligneCommandeRepository.save(ligneCommande);
        return ResponseEntity.ok(updatedLigneCommande);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLigneCommande(@PathVariable("id") int id) {
        if (!ligneCommandeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ligneCommandeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
