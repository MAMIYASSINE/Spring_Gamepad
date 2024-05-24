package game.project.gamoo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import game.project.gamoo.models.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer>{

}
