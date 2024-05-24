package game.project.gamoo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import game.project.gamoo.models.Jeu;

public interface JeuRepository extends JpaRepository<Jeu,Integer> {

    List<Jeu> findByCategorieId(int categorieId);

}
