package entities;

public class Changement {
    private Long id;
    private Long matchId;
    private Long joueurSortantId;
    private Long joueurEntrantId;
    private int minuteChangement;

    public Changement(Long id, Long matchId, Long joueurSortantId, Long joueurEntrantId, int minuteChangement) {
        this.id = id;
        this.matchId = matchId;
        this.joueurSortantId = joueurSortantId;
        this.joueurEntrantId = joueurEntrantId;
        this.minuteChangement = minuteChangement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getJoueurSortantId() {
        return joueurSortantId;
    }

    public void setJoueurSortantId(Long joueurSortantId) {
        this.joueurSortantId = joueurSortantId;
    }

    public Long getJoueurEntrantId() {
        return joueurEntrantId;
    }

    public void setJoueurEntrantId(Long joueurEntrantId) {
        this.joueurEntrantId = joueurEntrantId;
    }

    public int getMinuteChangement() {
        return minuteChangement;
    }

    public void setMinuteChangement(int minuteChangement) {
        this.minuteChangement = minuteChangement;
    }
}
