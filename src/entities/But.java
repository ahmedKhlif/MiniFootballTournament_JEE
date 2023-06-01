package entities;

public class But {
    private int id;
    private int matchId;
    private int joueurMarqueurId;

    public But(int id, int matchId, int joueurMarqueurId) {
        this.id = id;
        this.matchId = matchId;
        this.joueurMarqueurId = joueurMarqueurId;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getJoueurMarqueurId() {
        return joueurMarqueurId;
    }

    public void setJoueurMarqueurId(int joueurMarqueurId) {
        this.joueurMarqueurId = joueurMarqueurId;
    }
}