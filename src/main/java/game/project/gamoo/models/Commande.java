package game.project.gamoo.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private Date dateCommande;
    @ManyToMany
    @JoinTable(
        name = "ligne_commande", 
        joinColumns = @JoinColumn(name = "commande_id"), 
        inverseJoinColumns = @JoinColumn(name = "jeu_id")
    )
    private List<Jeu> jeux;
    @ManyToOne
//    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public List<Jeu> getJeux() {
		return jeux;
	}
	public void setJeux(List<Jeu> jeux) {
		this.jeux = jeux;
	}
    

}
