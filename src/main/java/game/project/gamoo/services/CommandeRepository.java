package game.project.gamoo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import game.project.gamoo.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Integer>{

}
