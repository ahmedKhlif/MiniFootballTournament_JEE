package entities;

import java.time.LocalDate;

public class Joueur {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String pays;
    private double salaire;
    private int matchsJoues;
    private int avertissementsTotal;
    private int avertissementsActifs;
    private int expulsionsTotal;
    private int matchsSuspendus;
    private boolean competitif;

    public Joueur(Long id, String nom, String prenom, LocalDate dateNaissance, String pays, double salaire, int matchsJoues,
                  int avertissementsTotal, int avertissementsActifs, int expulsionsTotal, int matchsSuspendus, boolean competitif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.pays = pays;
        this.salaire = salaire;
        this.matchsJoues = matchsJoues;
        this.avertissementsTotal = avertissementsTotal;
        this.avertissementsActifs = avertissementsActifs;
        this.expulsionsTotal = expulsionsTotal;
        this.matchsSuspendus = matchsSuspendus;
        this.competitif = competitif;
    }
    // Getters and setters for all the attributes

   

    
    // Getters and setters
    
    public Long getId() {
		return id;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public int getMatchsJoues() {
        return matchsJoues;
    }

    public void setMatchsJoues(int matchsJoues) {
        this.matchsJoues = matchsJoues;
    }

    public int getAvertissementsTotal() {
        return avertissementsTotal;
    }

    public void setAvertissementsTotal(int avertissementsTotal) {
        this.avertissementsTotal = avertissementsTotal;
    }

    public int getAvertissementsActifs() {
        return avertissementsActifs;
    }

    public void setAvertissementsActifs(int avertissementsActifs) {
        this.avertissementsActifs = avertissementsActifs;
    }

    public int getExpulsionsTotal() {
        return expulsionsTotal;
    }

    public void setExpulsionsTotal(int expulsionsTotal) {
        this.expulsionsTotal = expulsionsTotal;
    }

    public int getMatchsSuspendus() {
        return matchsSuspendus;
    }

    public void setMatchsSuspendus(int matchsSuspendus) {
        this.matchsSuspendus = matchsSuspendus;
    }

    public boolean isCompetitif() {
        return competitif;
    }

    public void setCompetitif(boolean competitif) {
        this.competitif = competitif;
    }
  

    public void setId(Long id) {
        this.id = id;
    }
}
