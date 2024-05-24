package game.project.gamoo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import game.project.gamoo.models.Client;
import game.project.gamoo.services.ClientRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(savedClient);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> editClient(@Valid @RequestBody Client client, @PathVariable("id") int id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") int id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
