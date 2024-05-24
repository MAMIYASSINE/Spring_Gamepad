package game.project.gamoo.models;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomCateg;

    @OneToMany(mappedBy = "categorie")
    private List<Jeu> jeux;  // Liste des jeux associés à cette catégorie

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nomCateg;
    }

    public void setNom(String nomCateg) {
        this.nomCateg = nomCateg;
    }

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
    }
}
