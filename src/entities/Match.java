package entities;

public class Match {
    private Long id;
    private Long journeeId;
    private Long equipeDomicileId;
    private Long equipeVisiteurId;
    private Integer scoreDomicile;
    private Integer scoreVisiteur;

    public Match(Long id, Long journeeId, Long equipeDomicileId, Long equipeVisiteurId, Integer scoreDomicile, Integer scoreVisiteur) {
        this.id = id;
        this.journeeId = journeeId;
        this.equipeDomicileId = equipeDomicileId;
        this.equipeVisiteurId = equipeVisiteurId;
        this.scoreDomicile = scoreDomicile;
        this.scoreVisiteur = scoreVisiteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJourneeId() {
        return journeeId;
    }

    public void setJourneeId(Long journeeId) {
        this.journeeId = journeeId;
    }

    public Long getEquipeDomicileId() {
        return equipeDomicileId;
    }

    public void setEquipeDomicileId(Long equipeDomicileId) {
        this.equipeDomicileId = equipeDomicileId;
    }

    public Long getEquipeVisiteurId() {
        return equipeVisiteurId;
    }

    public void setEquipeVisiteurId(Long equipeVisiteurId) {
        this.equipeVisiteurId = equipeVisiteurId;
    }

    public Integer getScoreDomicile() {
        return scoreDomicile;
    }

    public void setScoreDomicile(Integer scoreDomicile) {
        this.scoreDomicile = scoreDomicile;
    }

    public Integer getScoreVisiteur() {
        return scoreVisiteur;
    }

    public void setScoreVisiteur(Integer scoreVisiteur) {
        this.scoreVisiteur = scoreVisiteur;
    }
}
