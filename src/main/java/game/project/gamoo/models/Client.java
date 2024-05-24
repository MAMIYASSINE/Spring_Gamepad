package game.project.gamoo.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Le champ de nom ne doit pas etre null")
	private String nom;
	@NotEmpty(message = "Le champ de prenom ne doit pas etre null")
	private String prenom;
	@NotEmpty(message = "Le champ de email ne doit pas etre null")
	private String email;
	@NotEmpty(message = "Le champ de password ne doit pas etre null")
    @Size(min = 8, max = 10, message = "Le mot de passe doit contenir entre 8 et 10 caractères")
	private String password;
	@OneToMany(mappedBy = "client")
    private List<Commande> commandes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
