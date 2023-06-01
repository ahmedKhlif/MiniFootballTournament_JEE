package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private String pays;
    private Entraineur entraineur;
    private List<Joueur> joueurs;

    public Equipe(Long id, String nom, LocalDate dateCreation, String pays, Entraineur entraineur) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.pays = pays;
        this.entraineur = entraineur;
        this.joueurs = new ArrayList<>();
    }

    // Getters and Setters

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    // Add a joueur to the team
    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }

    // Remove a joueur from the team
    public void removeJoueur(Joueur joueur) {
        joueurs.remove(joueur);
    }
}
