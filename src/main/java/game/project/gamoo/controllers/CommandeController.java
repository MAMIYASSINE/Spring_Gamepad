package game.project.gamoo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import game.project.gamoo.models.Commande;
import game.project.gamoo.services.CommandeRepository;
import jakarta.validation.Valid;

import java.util.List;



@RestController
@RequestMapping("/commandes")
public class CommandeController {
	@Autowired
	private CommandeRepository commandeRepository;
	
    @GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Commande> getCommande(@PathVariable("id") int id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commande);
    }

    @PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Commande> createCommande(@Valid @RequestBody Commande commande) {
        Commande savedCommande = commandeRepository.save(commande);
        return ResponseEntity.ok(savedCommande);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Commande> editCommande(@Valid @RequestBody Commande commande, @PathVariable("id") int id) {
        if (!commandeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        commande.setId(id);
        Commande updatedCommande = commandeRepository.save(commande);
        return ResponseEntity.ok(updatedCommande);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable("id") int id) {
        if (!commandeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        commandeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
