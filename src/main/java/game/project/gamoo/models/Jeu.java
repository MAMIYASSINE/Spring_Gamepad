//package game.project.gamoo.models;
//
//import java.sql.Date;
//import java.util.List;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.DecimalMin;
//
//@Entity
//public class Jeu {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@NotEmpty(message = "Le champ de title ne doit pas etre null")
//	private String title;
//
//	@NotEmpty(message = "Le champ de console ne doit pas etre null")
//	private String console;
//
//	@Positive(message = "Le prix doit être positif")
//	private double prix;
//
//	private boolean il_y_a_promo;
//
//	@DecimalMin(value = "0.0", inclusive = false, message = "Le prix promo doit être supérieur à 0 si il y a promo")
//	private double prixPromo;
//
//	@NotEmpty(message = "Le champ d'image du jeu ne doit pas être vide")
//	private String imgJeu;
//
//	@Min(value = 0, message = "La quantité en stock ne peut pas être négative")
//	private int qtStock;
//
//	private boolean estDispo;
//
//	private Date createdAt;
//	@ManyToOne
////    @JoinColumn(name = "categorie_id")
//	private Categorie categorie;
//
//    @ManyToMany(mappedBy = "jeux")
//    private List<Commande> commandes;
//	
//	public List<Commande> getCommandes() {
//		return commandes;
//	}
//
//	public void setCommandes(List<Commande> commandes) {
//		this.commandes = commandes;
//	}
//
//	public Categorie getCategorie() {
//		return categorie;
//	}
//
//	public void setCategorie(Categorie categorie) {
//		this.categorie = categorie;
//	}
//
//	public List<Panier> getPaniers() {
//		return paniers;
//	}
//
//	public void setPaniers(List<Panier> paniers) {
//		this.paniers = paniers;
//	}
//
//	@ManyToMany(mappedBy = "jeux")
//	private List<Panier> paniers;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getConsole() {
//		return console;
//	}
//
//	public void setConsole(String console) {
//		this.console = console;
//	}
//
//	public double getPrix() {
//		return prix;
//	}
//
//	public void setPrix(double prix) {
//		this.prix = prix;
//	}
//
//	public boolean isIl_y_a_promo() {
//		return il_y_a_promo;
//	}
//
//	public void setIl_y_a_promo(boolean il_y_a_promo) {
//		this.il_y_a_promo = il_y_a_promo;
//	}
//
//	public double getPrixPromo() {
//		return prixPromo;
//	}
//
//	public void setPrixPromo(double prixPromo) {
//		this.prixPromo = prixPromo;
//	}
//
//	public String getImgJeu() {
//		return imgJeu;
//	}
//
//	public void setImgJeu(String imgJeu) {
//		this.imgJeu = imgJeu;
//	}
//
//	public int getQtStock() {
//		return qtStock;
//	}
//
//	public void setQtStock(int qtStock) {
//		this.qtStock = qtStock;
//	}
//
//	public boolean isEstDispo() {
//		return estDispo;
//	}
//
//	public void setEstDispo(boolean estDispo) {
//		this.estDispo = estDispo;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//}

package game.project.gamoo.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.DecimalMin;

@Entity
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Le champ de title ne doit pas etre null")
    private String title;

    @NotEmpty(message = "Le champ de console ne doit pas etre null")
    private String console;

    @Positive(message = "Le prix doit être positif")
    private double prix;

    private boolean il_y_a_promo;

    @DecimalMin(value = "0.0", inclusive = false, message = "Le prix promo doit être supérieur à 0 si il y a promo")
    private double prixPromo;

    @NotEmpty(message = "Le champ d'image du jeu ne doit pas être vide")
    private String imgJeu;

    @Min(value = 0, message = "La quantité en stock ne peut pas être négative")
    private int qtStock;

    private boolean estDispo;

    private Date createdAt;

    @ManyToOne
    @JsonIgnore
    private Categorie categorie;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isIl_y_a_promo() {
        return il_y_a_promo;
    }

    public void setIl_y_a_promo(boolean il_y_a_promo) {
        this.il_y_a_promo = il_y_a_promo;
    }

    public double getPrixPromo() {
        return prixPromo;
    }

    public void setPrixPromo(double prixPromo) {
        this.prixPromo = prixPromo;
    }

    public String getImgJeu() {
        return imgJeu;
    }

    public void setImgJeu(String imgJeu) {
        this.imgJeu = imgJeu;
    }

    public int getQtStock() {
        return qtStock;
    }

    public void setQtStock(int qtStock) {
        this.qtStock = qtStock;
    }

    public boolean isEstDispo() {
        return estDispo;
    }

    public void setEstDispo(boolean estDispo) {
        this.estDispo = estDispo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

   
}
